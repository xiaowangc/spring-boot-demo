package com.chige.controller;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Jasypt也即Java Simplified Encryption。默认使用的是PBEWITHMD5ANDDES算法。
 * 主要用于信息的加密操作
 * @author chige
 * @date 12月12日
 */
@Slf4j
@RestController
public class JasyptController {

    @Value("${info.username}")
    private String username;
    @Value("${jasypt.encryptor.password}")
    private String salt;

    @RequestMapping("/jasypt")
    public String jasyptModle(){
        StringBuilder sb = new StringBuilder();
        sb.append(username);
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(salt);
        String decrypt = textEncryptor.decrypt(username);
        log.info("明文为{}",decrypt);
        log.info(sb.toString());
        return sb.toString();
    }

    //vQtmcvRktnQ2VxUzBDsOlQ==


}
