package com.cagdasalagoz.authservice;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;

@Component
public class AuthUtil {

    private static final int LENGTH = 32;
    private static SecureRandom random = new SecureRandom();

    public static String generateRandomSessionId() {

        BigInteger bigInteger = new BigInteger(130, random);

        String sessionId = String.valueOf(bigInteger.toString(LENGTH));

        return sessionId.toUpperCase();
    }
}
