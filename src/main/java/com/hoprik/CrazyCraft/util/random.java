package com.hoprik.CrazyCraft.util;

public class random {
    public static int random(int a, int b){
        return a + (int) (Math.random() * ((b - a) + 1));
    }
}
