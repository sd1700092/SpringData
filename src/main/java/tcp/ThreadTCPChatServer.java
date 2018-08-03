package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 * created: 2018-08-03 17:05
 */
public class ThreadTCPChatServer {

    private Integer port = 8000;
    private ServerSocket serverSocket;//服务器
    private Socket accept = null;
    private ExecutorService executorService;

    public ThreadTCPChatServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("server ok");
            this.executorService = Executors.newFixedThreadPool(3);
        } catch (Exception e) {
            System.err.println("server error");
        }
    }

    public static void main(String[] args) {
        new ThreadTCPChatServer().service();
    }

    private void service() {
        while (true) {
            Socket accept = null;
            try {
                accept = serverSocket.accept();
                executorService.execute(new TWorker(accept));
//                new Thread(new TWorker(accept)).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String reply(String word) {
        return String.format("you said %s", word);
    }

    class TWorker implements Runnable {
        private Socket accept;

        public TWorker(Socket accept) {
            this.accept = accept;
        }

        @Override
        public void run() {
            try {
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
}
