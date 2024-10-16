package utb.fai;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {

        // Implement input parameter processing
        int port = Integer.parseInt(args[0]);
        int max_threads = Integer.parseInt(args[1]);
        ExecutorService exec = Executors.newFixedThreadPool(max_threads);
        // Implementation of the main server loop
        
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) { 

                Socket socket = serverSocket.accept();
                exec.execute(new ClientThread(socket)); 
            }
            
        } catch(IOException e) {
            e.printStackTrace();
        }
        
    }
}
