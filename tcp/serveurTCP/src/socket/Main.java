/**
 * 
 */
package socket;

import java.io.IOException;

/**
 * @author ZHU Yuting
 * 
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {

        System.out.println("Begin...");
        MultiServer server = new MultiServer();
        server.server();
    }

}
