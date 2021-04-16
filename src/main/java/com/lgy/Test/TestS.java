package com.lgy.Test;



import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;

/*
 *@autor lgy
 *
 *@date 2021/3/31 11:19
 ****/
public class TestS {
    public static void main(String[] args) {
        List<Map<Object, Object>> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Map<Object, Object> map = new HashMap<>();
            if (i == 3) {
                map.put("CHECKSTATUS", "检查中");
            } else if (i == 2) {
                map.put("CHECKSTATUS", "待检查");

            } else {
                map.put("CHECKSTATUS", "整改中");

            }
            //map.put("CHECKSTATUS", "整改中");
            list.add(map);
        }
        //isUpdate(list);
        //System.out.println(getDate());
       // getRodem();
        System.out.println(getWhitePhoto("123456"));
    }

    static void isUpdate(List<Map<Object, Object>> allBuildisSubmit) {
        boolean isTaskEnd = false;
        for (int i = 0; i < allBuildisSubmit.size(); i++) {

            if ((allBuildisSubmit.get(i).get("CHECKSTATUS").equals("检查中")) || (allBuildisSubmit.get(i).get("CHECKSTATUS").equals("待检查"))) {
                isTaskEnd = true;
                break;
            }

        }
        if (!isTaskEnd) {
            System.out.println("更改");
        }


    }

    static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(new Date());
        //3752000002397985220210319161838
        //20210414165903
        return date;
    }

    static void getRodem() {
        Random ran = new Random();

        boolean flag = true;
        long c1;
        while (flag) {
            int a = ran.nextInt(99999999);

            int b = ran.nextInt(99999999);

            long c = a * 100000000L + b;

            if (c > 1000000000000000L && c < 9999999999999999L) {
                flag = false;

                c1 = c;

                String num = String.valueOf(c1);
                System.out.println(num);
            }


        }


    }
    static String getWhitePhoto(String photoid){
        JSONObject resultData= new JSONObject();
        Map<String,Object> mapwhite = new HashMap<String,Object>();
        mapwhite.put("val",photoid);
        mapwhite.put("imgtype","upload");
        String json = resultData.toJSONString(mapwhite);
        return json;

    }
}