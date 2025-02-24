package hashingalgo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashConverter {
    
    
    public static String getSHA256(String input) {
        return getHash(input, "SHA-256");
    }
    
    public static String getSHA512(String input) {
        return getHash(input, "SHA-512");
    }
    
    public static String getSHA3_256(String input) {
        return getHash(input, "SHA3-256");
    }
    
    public static String getSHA3_512(String input) {
        return getHash(input, "SHA3-512");
    }
    
    private static String getHash(String input, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hash = digest.digest(input.getBytes());
            
            // Convert byte array to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String input) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("SHA-256: " + getSHA256(input));
        System.out.println("SHA-512: " + getSHA512(input));
        System.out.println("SHA3-256: " + getSHA3_256(input));
        System.out.println("SHA3-512: " + getSHA3_512(input));
        
        scanner.close();
    }
}