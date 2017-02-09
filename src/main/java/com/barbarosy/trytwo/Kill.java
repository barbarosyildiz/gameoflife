package com.barbarosy.trytwo;

/**
 * Created by barbarosy on 09.02.2017.
 */
public class Kill {
    public static Object kill(){
        System.out.println("kill");
        Global.status=false;
        return new Object();
    }
}
