/**
 * 
 */
package Serveur;

import java.io.IOException;

/**
 * @author apple
 * 
 */
public class Main {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        
        Serveur socketServeur = new Serveur();
        System.out.println("Serveur...");
        while (true) {
            socketServeur.receive();
            socketServeur.response("Get it!");
        }
    }

}
