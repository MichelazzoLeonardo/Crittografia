package Cifrario;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Forzatura {
    private static HashSet<String> dictionary;
    public static void setUp() {
        dictionary = new HashSet<>();
        //setup dictionary
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Cifrario/dizionario.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dictionary.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //symbols
        dictionary.add("5aii");
        dictionary.add("!");
        dictionary.add("\"");
        dictionary.add("#");
        dictionary.add("$");
        dictionary.add("%");
        dictionary.add("&");
        dictionary.add("'");
        dictionary.add("(");
        dictionary.add(")");
        dictionary.add("*");
        dictionary.add("+");
        dictionary.add(",");
        dictionary.add("-");
        dictionary.add(".");
        dictionary.add("/");
        dictionary.add("0");
        dictionary.add("1");
        dictionary.add("2");
        dictionary.add("3");
        dictionary.add("4");
        dictionary.add("5");
        dictionary.add("6");
        dictionary.add("7");
        dictionary.add("8");
        dictionary.add("9");
        dictionary.add(":");
        dictionary.add(";");
        dictionary.add("<");
        dictionary.add("=");
        dictionary.add(">");
        dictionary.add("?");
        dictionary.add("@");
        dictionary.add("[");
        dictionary.add("\\");
        dictionary.add("]");
        dictionary.add("^");
        dictionary.add("_");
        dictionary.add("`");
    }
    private static char decryptChar(char c, int key) {
        return (char) (((((int) c) - key + 90 - 32) % 90) + 32);
    }
    private static String decryptMessage(String message, int[] numericKey) {
        String result = "";
        for (int i = 0; i < message.length(); i++)
            result += decryptChar(message.charAt(i), numericKey[i % numericKey.length]);
        return result;
    }
    private static int check(String message) {
        int count = 0;
        String[] words = message.split(" ");
        for (String word : words) {
            if (dictionary.contains(word.toLowerCase()))
                count++;
        }
        return count;
    }
    public static String force(String message){
        setUp();
        String msg, result = "";
        int[] chiave = new int[4];
        int right_words_counter = 0, n = 0;
        int range = 90;
        for (int i = 0; i < range; i++) {
            System.out.println(i);
            for (int j = 0; j < range; j++) {
                for (int k = 0; k < range; k++) {
                    for (int l = 0; l < range; l++) {
                        msg = decryptMessage(message, new int[] {i, j, k, l});
                        n = check(msg);
                        if (n > right_words_counter) {
                            result = msg;
                            chiave = new int[] {i, j, k, l};
                        }
                        if(n == msg.split(" ").length) {
                            chiave = new int[] {i, j, k, l};
                            System.out.println("chiave: " + Arrays.toString(chiave) + " : " + n);
                            return msg;
                        }
                    }
                }
            }
        }
        System.out.println("chiave: "+ Arrays.toString(chiave));
        return result;
    }
}
