/**
 * 
 */

import java.io.IOException;

/**
 * @author apple
 * 
 */
public class Main {
    private static final String CLIENT = "Client...";

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Client client = new Client();
        System.out.println(CLIENT);
        client.send(System.in.toString());
        String info = client.receive();
        System.out.println(info);

    }

}
