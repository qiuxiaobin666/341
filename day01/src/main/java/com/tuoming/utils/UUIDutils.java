package com.tuoming.utils;

import java.util.UUID;

public class UUIDutils {
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        return s.replace("-","");
    }
}
