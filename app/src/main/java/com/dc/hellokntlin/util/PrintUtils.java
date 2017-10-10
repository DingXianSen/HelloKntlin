package com.dc.hellokntlin.util;

/**
 * Created by YAOJM on 2017/6/22.
 */

public class PrintUtils {

    public static String printLine(String msg) {


//        byte[] bytes = BytesUtil.hexString2Bytes(msg);

        String s = "0006"+str2HexStr(msg);
//        String ss = str2HexStr(String.format("%04d", s.length()));

        msg = "05" + String.format("%04d", s.length()) + s;

        return msg;
    }

    public static String str2HexStr(String str) {

        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder();
        byte[] bs = str.getBytes();
        int bit;

        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
//            sb.append(' ');
        }
        return sb.toString().trim();
    }

}
