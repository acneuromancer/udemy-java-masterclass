package section_20_networkprogramming._02_clientandserverthread;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                // Socket socket = serverSocket.accept();
                // Echoer echoer = new Echoer(socket);
                // echoer.start();
                new Echoer(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }
}
