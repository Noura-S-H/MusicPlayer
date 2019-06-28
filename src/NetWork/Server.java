package NetWork;

import NetWork.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread implements Runnable{
    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private ArrayList<Client> clients;

    // constructor with port
    public Server(int port) {
        // starts server and waits for a connection
        try {
            server = new ServerSocket(port);
        } catch (IOException i) {
            System.out.println(i);
        }

    }

    @Override
    public void run() {

        System.out.println("Server started");
        System.out.println("Waiting for a client ...");
        while (true) {
            try {

                socket = server.accept();
                System.out.println("Client accepted");

                // takes input from the client socket
               // BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //String input = in.readLine();
                //input = appendchar(input);

                System.out.println("Closing connection");
                // close connection
                //in.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    public void addClient(Client c){
        clients.add(c);
    }

    public static void  main(String[] args){
        Server s = new Server(2000);
        s.start();
    }



}
