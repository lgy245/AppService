package com.lgy.until;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *@autor lgy
 *
 *@date 2021/4/8 17:34
 ****/
public  class Until {
    public static int MathRodem(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        int min =1000,max=9999;
        return (int)(min+Math.random()*max) + Integer.valueOf(sdf.format(date));
    }
}
