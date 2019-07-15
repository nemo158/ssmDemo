package com.demo.mms.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author  teacher
 */
public class IDGenerator {

    private static SimpleDateFormat df = new SimpleDateFormat("yyMMddHH");

    public static String getId() {
        return df.format(new Date()) + "-" + UUID.randomUUID().toString().replace("-", "").substring(9);
    }

    public static void main(String[] args) {
        int epoch=100;
        for (int i = 0; i < epoch; i++) {

            System.out.println(IDGenerator.getId());
        }
    }
}
