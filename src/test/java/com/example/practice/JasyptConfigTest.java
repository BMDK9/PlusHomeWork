package com.example.practice;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JasyptConfigTest {

    @Test
    void stringEncryptor() {
        // given
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("11111");
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
        String test = "test";

        // when, then
        String actual = encryptor.encrypt(test);
        Assertions.assertEquals(test, encryptor.decrypt(actual));
        System.out.println(actual);
    }
}