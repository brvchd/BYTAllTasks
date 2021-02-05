package main;

import java.io.IOException;
import java.net.URLConnection;
import java.util.Date;
import java.util.Observable;

public class SubscriptionManager extends Observable {
    private URLWrapper url;
    private long time;

    Memento createSnapshot(){
        return new Memento(url.getUrlPath(),time);
    }

    private static class Memento{
        String memUrl;
        long memTime;
        Memento(String url, long time) {
            memUrl = url;
            memTime = time;
        }
        String getState(){
            return "URL: " + memUrl + ", last updated: " + new Date(memTime);
        }

    }

    String getSnapshotState(){
        return createSnapshot().getState();
    }

    public SubscriptionManager(URLWrapper url) {
        this.url = url;
        time = 0;
    }

    public void check() throws IOException {
            URLConnection connection = url.openConnection();
            long modifiedTime = connection.getLastModified();
            if (time!=modifiedTime){
                this.time = modifiedTime;
                setChanged();
                notifyObservers(new Date(time));
            }else{

                System.out.println("No changes");
            }
    }
}
