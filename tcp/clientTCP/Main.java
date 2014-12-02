/**
 * Created by mael on 07/11/14.
 */
import requete.Requete;

public class Main {
    /**
     * @param args
     */

    private static String BIENVENU = "Bonjour, bienvenu sur le serveur de surnoms";

    public static void main(String[] args) {
        System.out.println(BIENVENU);
        new socket.Client();
       // System.out.println(new Requete("SAVE%%NAME=\"nom\"%%SURNAME=\"surnom\""));

    /*String test= "toto%%titi%%tutu='bob sinclar'";
    System.out.println(test.split("%%",2)[0]);
    System.out.println(test);*/

    }
}
