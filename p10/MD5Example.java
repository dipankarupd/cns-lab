package p10;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example {

    public static void main(String[] args) {
        String input = "Hello, MD5!";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(input.getBytes());

            byte[] digest = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            System.out.println("MD5 Hash: " + sb.toString());

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
}
