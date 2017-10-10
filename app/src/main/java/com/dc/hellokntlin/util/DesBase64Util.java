package com.dc.hellokntlin.util;

import android.util.Base64;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Locale;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * Created by dingchao on 2017/9/14.
 */

/**
 * @author dingchao
 * @ClassName:
 * @Description: 两次加密——加密解密工具包
 * @TODO: 第一次进行DES加密，然后在进行Base64加密
 */
public class DesBase64Util {
    public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
    public static final String POS_KEY = "posplatf";

    /**
     * DES算法，加密
     *
     * @param data 待加密字符串
     *  key  加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     * @throws Exception
     */
    public static String encode(String data) {
        if (data == null)
            return null;
        try {
            /*TODO todo测试效果*/
            DESKeySpec dks = new DESKeySpec(POS_KEY.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec(POS_KEY.getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            byte[] bytes = cipher.doFinal(data.getBytes());
            String desStr = byte2String(bytes);
            return new String(Base64.encode(desStr.getBytes(), Base64.DEFAULT));
//            return Base64.encodeBase64String(desStr.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }

    /**
     * DES算法，解密
     *
     * @param data 待解密字符串
     *    解密私钥，长度不能够小于8位
     * @return 解密后的字节数组
     * @throws Exception 异常
     */
    public static String decode(String data) {
        if (data == null)
            return null;
        try {
//            byte[] dataByte = Base64.decodeBase64(data);
            byte[] dataByte = Base64.decode(data, Base64.DEFAULT);
            DESKeySpec dks = new DESKeySpec(POS_KEY.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec(POS_KEY.getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
            return new String(cipher.doFinal(byte2hex(dataByte)));
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }

    /**
     * 二行制转字符串
     *
     * @param b
     * @return
     */
    private static String byte2String(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);

        }
        return hs.toString().toUpperCase(Locale.CHINA);
    }

    /**
     * 二进制转化成16进制
     *
     * @param b
     * @return
     */
    private static byte[] byte2hex(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException();
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

}
