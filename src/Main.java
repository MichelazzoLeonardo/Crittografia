import Cifrario.Forzatura;
import Cifrario.VigenereCipher;

public class Main {
    public static void main(String[] args) {
        String crypted_message = "duqr\"aprq c$vuvxk";

        String message = Forzatura.force(crypted_message);
        System.out.println("messaggio decriptato: " + message);
    }
}