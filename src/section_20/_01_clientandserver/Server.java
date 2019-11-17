package section_20._01_clientandserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) { // port number must be an integer between 0 and 65535 incl.
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // whether you want to automatically flush the output stream

            while(true) {
                String echoString = input.readLine();
                if (echoString.equals("exit")) {
                    break;
                }
                System.out.println("Input from client: " + echoString);
                output.println("Echo from server: " + echoString);
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }

}
