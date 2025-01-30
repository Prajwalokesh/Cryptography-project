import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

class Elgamal{
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(512, random);
        BigInteger g = new BigInteger("2");
        BigInteger x = new BigInteger(512, random).mod(p.subtract(BigInteger.ONE));
        BigInteger y = g.modPow(x, p);
        BigInteger r = new BigInteger(512, random).mod(p.subtract(BigInteger.ONE));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text message to encrypt:");
        String message = sc.nextLine();
        BigInteger messageNum = new BigInteger(message.getBytes(StandardCharsets.UTF_8));

        BigInteger c1 = g.modPow(r, p);
        BigInteger c2 = messageNum.multiply(y.modPow(r, p)).mod(p);
        BigInteger decryptedNum = c2.multiply(c1.modPow(p.subtract(BigInteger.ONE).subtract(x), p)).mod(p);
        String decrypted = new String(decryptedNum.toByteArray(), StandardCharsets.UTF_8);

        System.out.println("Public Key (p, g, y): " + p + ", " + g + ", " + y);
        System.out.println("Private Key (x): " + x);
        System.out.println("Ciphertext (c1, c2): " + c1 + ", " + c2);
        System.out.println("Decrypted Message: " + decrypted);
        sc.close();
    }
}
