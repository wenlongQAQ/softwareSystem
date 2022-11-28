package com.zzut.softwaresystem.common;

import com.zzut.softwaresystem.result.R;

import java.util.Random;

public class RandomTag {
    public static final char[] RANDOM_CHAR ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            '0','1','2','3','4','5','6','7','8','9'};
    public static String getRandomTag(){
        Random random = new Random();
        StringBuilder tag = new StringBuilder("郑");
        while(tag.length()!=6){
            int i = random.nextInt(35);
            if (i<=25){
                char r= (char) (RANDOM_CHAR[i]-32);
                tag.append(r);
            }else {
                tag.append(RANDOM_CHAR[i]);
            }
        }
        String randomTag = tag.toString();
        return randomTag;
    }
}
