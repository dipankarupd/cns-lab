package lab.p9;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {

    public static void main(String[] args) {
        String input = "Hello, SHA-512!";

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            md.update(input.getBytes());

            byte[] digest = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            System.out.println("SHA-512 Hash: " + sb.toString());

        } catch (NoSuchAlgorithmException e) {
            System.out.println("SHA-512 algorithm not available.");
            e.printStackTrace();
        }
    }
}