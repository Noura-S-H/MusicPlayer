package NetWork;

import Graphics.east.Friend;
import NetWork.Client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread implements Runnable{
    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
   // private ArrayList<Client> clients;
    ArrayList<Friend> friends = new ArrayList<>();

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
      //  while (true) {
            try {

                socket = server.accept();
                System.out.println("Client accepted");

               // ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                String data = (String) in.readObject();
                String[] recive = data.split(":");
                friends.add(new Friend(recive[0],recive[1],recive[2]));
                // close connection
                //out.flush();
                in.close();
                socket.close();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        //}


    }

    public ArrayList<Friend> getFriends(){
        return friends;
    }


//    public static void  main(String[] args){
       // Server s = new Server(2000);
      //  s.start();
    //}



}
