package com.chige.controller;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestJasyptController {

    @Autowired
    private JasyptController controller;

//    @Value("${info.name}")
//    private String name;
//    @Value("${jasypt.encryptor.password}")
//    private String salt;
    @Test
    public void test1(){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        String salt = "vQtmcvRktnQ2VxUzBDsOlQ==";
        // 0.加盐salt,设置密钥
        textEncryptor.setPassword(salt);
        // 1.对明文密码test123进行加密，得到的密文可代替明文密码在配置文件中配置
        String encrypt0 = textEncryptor.encrypt("test123");
        log.info("明文密码加密后的密文为{}",encrypt0);
        // 2.对密文再进行加密
//        String encrypt = textEncryptor.encrypt("encrypt0");
//        log.info("加密后的密文为：{}",encrypt);
//        String decrypt = textEncryptor.decrypt(encrypt);
        String result = textEncryptor.decrypt(encrypt0);
        log.info("解密后的明文为:{}",result);
    }
    @Test
    public void test2(){
        controller.jasyptModle();
    }
//    @Test
//    public void testDecrypt(){
//        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
//        log.info("密钥为{}",salt);
//        textEncryptor.setPassword(salt);
//        String decrypt = textEncryptor.decrypt(name);
//        log.info("明文为{}",decrypt);
//    }
}
