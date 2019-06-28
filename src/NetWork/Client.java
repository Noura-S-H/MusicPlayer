package NetWork;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Client extends Thread implements Runnable {

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
        while (true) {


        }
    }

    public static void main(String[] args){
        Client c = new Client("127.0.0.1",2000);
        c.start();
    }
}