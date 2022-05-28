package com.example.bank.util;

import java.util.Base64;
import java.util.Random;

public class MyUtil {
    private static String pinGenerator() {
        return String.valueOf((int) (Math.random() * 9000) + 1000);
    }

    private static String generateCvc() {
        return String.valueOf((int) (Math.random() * 900) + 100);
    }

    public static String ibanGenerate(String country, Long bankId) {
        Random rng = new Random();
        long first16 = (rng.nextLong() % 100000000000000L) + 5200000000000000L;
        return country + bankId + first16;
    }
    public static String cardGenerator() {
        String card1 = String.valueOf((int) (Math.random() * 9000) + 1000);
        String card2 = String.valueOf((int) (Math.random() * 9000) + 1000);
        String card3 = String.valueOf((int) (Math.random() * 9000) + 1000);
        String card4 = String.valueOf((int) (Math.random() * 9000) + 1000);

        return card1 +"-"+ card2 +"-"+ card3 +"-"+card4;
    }

    public static String encodedPin() {
        return Base64.getEncoder().encodeToString(pinGenerator().getBytes());
    }

    public static String encodedCvc() {
        return Base64.getEncoder().encodeToString(generateCvc().getBytes());
    }

    public static String decodedString(String decoded) {
        byte[] decodedBytes = Base64.getDecoder().decode(decoded);
        return new String(decodedBytes);
    }
}
