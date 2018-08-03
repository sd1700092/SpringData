package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 * created: 2018-08-03 17:05
 */
public class TCPChatServer {

    private Integer port = 8000;
    private ServerSocket serverSocket;//服务器

    public TCPChatServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("server ok");
        } catch (Exception e) {
            System.err.println("server error");
        }
    }

    public static void main(String[] args) {
        new TCPChatServer().service();
    }

    private void service() {
        Socket accept = null;
        while (true) {
            try {
                accept = serverSocket.accept();

                System.out.println(String.format("conn ip: %s port %s", accept.getInetAddress(), accept.getPort()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                PrintWriter writer = new PrintWriter(accept.getOutputStream(), true);
                String word;
                while ((word = reader.readLine()) != null) {
                    if (word.equals("bye")) {
                        writer.println("bye");
                        break;
                    }
                    writer.println(reply(word));
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (accept != null) {
                    try {
                        accept.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private String reply(String word) {
        return String.format("you said %s", word);
    }
}
