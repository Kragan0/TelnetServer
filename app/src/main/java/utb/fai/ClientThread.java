package utb.fai;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket clientSocket;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    
    @Override
    public void run() {
        // Implementation of processing incoming communication from the telnet client
            try {
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());                
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));                
                String message;
                while ((message = reader.readLine()) != null)
                {
                    writer.println(message);
                    writer.flush();                     
                }
            
            } catch (Exception e) {
                e.printStackTrace();
            }
                
    }
}
