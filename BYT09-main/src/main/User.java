package main;

import java.util.Observable;
import java.util.Observer;

public class User implements Observer {
    String message;
    @Override
    public void update(Observable o, Object arg) {
        message = arg.toString();

        System.out.println("User's 1, web-page last updated date: " + message);
    }
    public String getMessage(){
        return message;
    }
}
