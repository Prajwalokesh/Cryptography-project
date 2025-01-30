import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
class RSA {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(512, random);
        BigInteger q = BigInteger.probablePrime(512, random);
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = new BigInteger("65537");
        BigInteger d = e.modInverse(phi);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text message to encrypt:");
        String message = sc.nextLine();
        BigInteger messageNum = new BigInteger(message.getBytes(StandardCharsets.UTF_8));

        BigInteger encrypted = messageNum.modPow(e, n);
        BigInteger decryptedNum = encrypted.modPow(d, n);
        String decrypted = new String(decryptedNum.toByteArray(), StandardCharsets.UTF_8);

        System.out.println("Public Key (n, e): " + n + ", " + e);
        System.out.println("Private Key (d): " + d);
        System.out.println("Encrypted Message: " + encrypted);
        System.out.println("Decrypted Message: " + decrypted);

        sc.close();
    }
}
