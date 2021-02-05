package main;

import java.io.*;

public class Main{
    public static void main(String[] args){

        String urlPja = "http://www.pja.edu.pl/";
        String storeStateDirection = "./States.txt";
        SubscriptionManager observable = null;

        try {
            observable = new SubscriptionManager(new URLWrapper(urlPja));
        } catch (IOException e) {
            e.printStackTrace();
        }
        User observer = new User();
        observable.addObserver(observer);

        String state;
        OutputStream os;

        try {
            while (true) {
                os = new FileOutputStream(new File(storeStateDirection));
                observable.check();
                state = observable.getSnapshotState();
                os.write(state.getBytes(), 0, state.length());
                os.close();
                Thread.sleep(6000);
            }
        }
        catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }

}
