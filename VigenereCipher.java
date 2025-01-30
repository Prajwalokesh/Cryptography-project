import java.util.Scanner;
class VigenereCipher {
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.replaceAll("\\s", "").toLowerCase();
        int keyIndex = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int offset = Character.isUpperCase(c) ? 'A' : 'a';
                int x = (c - offset + (key.charAt(keyIndex % key.length()) - 'a')) % 26;
                result.append((char) (x + offset));
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.replaceAll("\\s", "").toLowerCase();
        int keyIndex = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int offset = Character.isUpperCase(c) ? 'A' : 'a';
                int x = (c - offset - (key.charAt(keyIndex % key.length()) - 'a') + 26) % 26;
                result.append((char) (x + offset));
                keyIndex++;
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
        System.out.println("Enter the key:");
        String key = sc.nextLine();
        String encrypted = encrypt(text, key);
        System.out.println("Encrypted Text: " + encrypted);
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted Text: " + decrypted);
        sc.close();
    }
}
