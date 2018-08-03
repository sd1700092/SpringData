package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Administrator
 * created: 2018-08-03 19:36
 */
public class TCPChatClient {
    private String host = "localhost";
    private Integer port = 8000;
    private Socket socket;

    public TCPChatClient() {
        try {
            socket = new Socket(host, port);
            System.out.println("Client OK");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Client conn error");
        } 
    }

    private void say() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader server_reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String word;
        String msg;
        while ((word=reader.readLine())!= null) {
            writer.println(word);
            msg = server_reader.readLine();
            if (msg.equals("bye")) {
                System.out.println("bye");
                break;
            }
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        try {
            new TCPChatClient().say();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
