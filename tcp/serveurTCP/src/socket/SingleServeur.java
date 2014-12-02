package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleServeur {
    ServerSocket serverSocket = null;
    Socket clientSocket = null;

    // int port = 8888;

    public SingleServeur(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Connected");

    }

    public void essaie() throws IOException {
        try {
            while (true) {
                clientSocket = serverSocket.accept();
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                String result = bufferedReader.readLine();
                System.out.println("From Client: " + result);
                OutputStream os = clientSocket.getOutputStream();
                os.close();
                os.flush();
                clientSocket.close();
            }

        } catch (IOException e) {
            System.err.println(e);
        } finally {
            serverSocket.close();
        }
    }
}
