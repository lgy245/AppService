package com.lgy.interceptor;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.lgy.customAnnotation.PassToken;
import com.lgy.customAnnotation.UserLoginToken;
import com.lgy.pojo.UserSSO;
import com.lgy.service.UserSSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/*
 *@autor
 *
 *@date 2021/4/26 15:38
 ****/
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserSSOService userSSOService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //首先从请求头中获取token
        String token = request.getHeader("token");
        //如果不是映射方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();// 获取映射中的方法，
        //判断映射方法中是否有 passToken 注解 ，如果存在，认证通过
        if(method.isAnnotationPresent(PassToken.class)){//存在
            PassToken passToken = method.getAnnotation(PassToken.class); //获取当前注解
            if(passToken.required()){//当注解中required 返回true 是，通过， 自定义注解中，默认为ttrue
                return true;
            }
        }
        // 判断映射方法中有没有对应的 UserLogin （权限）注解，
        if(method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if(userLoginToken.required()){
                //判断当前token 是否为空
                if(token==null){
                    throw new RuntimeException("无token，请重新登录");
                }
                String userName ="";
                try {
                    userName = JWT.decode(token).getAudience().get(0);
                }catch (JWTDecodeException e){
                    throw new RuntimeException("取用户名报错");
                }
                // 获取之前存入token的 用户名

                // 查询用户名是否存在
                List<UserSSO> list = userSSOService.findById(userName);
                if(list.size()==0){
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                //验证token 是否可用
                // 获取密匙
                String usso = JSON.toJSONString(list.get(0));
                UserSSO userSSO = JSON.parseObject(usso,UserSSO.class);
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userSSO.getPassworld())).build();

                // 验证密匙
                try{
                    jwtVerifier.verify(token);
                }catch (TokenExpiredException a ){
                    throw new RuntimeException("登录超时，请重新登录");
                }catch (JWTVerificationException e){
                    throw new RuntimeException("验证token 失败");
                }
                return  true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
