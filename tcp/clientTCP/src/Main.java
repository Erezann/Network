/**
 * Created by mael on 07/11/14.
 */

public class Main {
    /**
     * @param args
     */

    private static String BIENVENU = "Bonjour, bienvenu sur le serveur de surnoms";

    public static void main(String[] args) {
        System.out.println(BIENVENU);
        new socket.Client();

    }
}
