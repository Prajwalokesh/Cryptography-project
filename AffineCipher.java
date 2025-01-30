import java.util.Scanner;
class AffineCipher {
    static int a = 5, b = 8;
    static int m = 26;

    public static String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int x = Character.toLowerCase(c) - 'a';
                result.append((char) (((a * x + b) % m) + 'a'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        int aInv = 0;
        for (int i = 0; i < m; i++) {
            if ((a * i) % m == 1) {
                aInv = i;
                break;
            }
        }
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int y = Character.toLowerCase(c) - 'a';
                result.append((char) (((aInv * (y - b + m)) % m) + 'a'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text to encrypt:");
        String text = sc.nextLine();
        String encrypted = encrypt(text);
        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypt(encrypted));
        sc.close();
    }
}
