import Cifrario.Forzatura;
import Cifrario.VigenereCipher;

public class Main {
    public static void main(String[] args) {

        String crypted_message = VigenereCipher.CryptMessage("Ciao sono la 5AII", "1 2 3 4");
        System.out.println("messaggio criptato: " + crypted_message);

        String message = Forzatura.force(crypted_message);
        System.out.println("messaggio decriptato: " + message);
    }
}