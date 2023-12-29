package Cifrario;

public class VigenereCipher {

    private static char CryptChar(char c, int key) {
        return (char) (((((int) c) - 32 + key) % 90) + 32);
    }

    public static String CryptMessage(String message, String key) {
        int[] n_key = TranslateKey(key);
        String result = "";
        for (int i = 0; i < message.length(); i++)
            result += CryptChar(message.charAt(i), n_key[i%n_key.length]);
        return result;
    }

    private static int[] TranslateKey(String alphabeticKey) {
        String[] k = alphabeticKey.split(" ");
        int[] key = new int[4];
        for (int i = 0; i < 4; i++)
            key[i] = Integer.parseInt(k[i]);
        return key;
    }


}
