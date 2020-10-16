package com.sdpm.sf.security.common.util;

import java.util.Base64;
import java.util.UUID;

/**
 * 密码加密器
 *
 * @author shirukai
 */
public class PasswordEncryptor {

    public static String encode(String password) {
        String slot16 = Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes()).substring(0, 32);
        return slot16 + Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static String decode(String s) {
        return new String(Base64.getDecoder().decode(s.substring(32)));
    }
}
