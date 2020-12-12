package com.chige.util;

import org.jasypt.util.text.BasicTextEncryptor;

public class JasyptUtil {

    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密密钥，salt盐，一旦被别人拿到，后果不堪设想
        textEncryptor.setPassword("DSGCgsdsd$%asc>sd|@s?GDE");
        //加密后的数据
        String enData = textEncryptor.encrypt("root");
        //解密后的数据（原数据）
        String deDate = textEncryptor.decrypt(enData);
        System.out.println("en Password :" + enData);
        System.out.println("de password:" + deDate);
        BasicTextEncryptor textEncryptor2 = new BasicTextEncryptor();
        textEncryptor2.setPassword("DSGCgsdsd$%as>sd|@s?GDE");

        String deData = textEncryptor2.decrypt(enData);
        System.out.println("deData " + deData);
    }
}
