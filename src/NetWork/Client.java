package NetWork;

import Graphics.Song;
import Graphics.east.Friend;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client extends Thread implements Runnable {

    Song s = new Song("src\\Files\\songTest\\ttt.mp3");
    Friend friendData = new Friend("user",null,null);

    ArrayList<Integer> ips = new ArrayList<Integer>();
    private Socket socket = null;

    // constructor to put ip address and port
    public Client(String address, int port) {
        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //while (true) {
            //new Data();
      //  PrintWriter writer = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

           // out.defaultWriteObject(data);
            out.writeObject(friendData);
           // out.writeObject(data);
            out.flush();
            out.close();
           // socket.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }



    public static void main(String[] args){
        Client c = new Client("127.0.0.1",2000);
        c.start();
    }
}