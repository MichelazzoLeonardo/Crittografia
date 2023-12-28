package Cifrario;

import java.util.Hashtable;

public class Forzatura {

    private static Hashtable<Integer, String> dictionary;
    private static void setUp() {
        dictionary = new Hashtable<>();
        //setup dictionary
        dictionary.put(1, "ciao");
    }
    private static char decryptChar(char c, int key) {
        return (char) (((((int) c) - 32 - key) % 90) + 32);
    }
    private static String decryptMessage(String message, int[] numericKey) {
        String result = "";
        for (int i = 0; i < message.length(); i++)
            result += decryptChar(message.charAt(i), numericKey[i % numericKey.length]);
        return result;
    }
    private static boolean check(String message) {
        return (dictionary.contains(message));
    }
    public static String force(String message){
        setUp();
        String msg;
        int range = 5;
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                for (int k = 0; k < range; k++) {
                    for (int l = 0; l < range; l++) {
                        msg = decryptMessage(message, new int[] {i,j,k,l});
                        if (check(msg)) {
                            return  msg;
                        }
                    }
                }
            }
        }
        return null;
    }
}
