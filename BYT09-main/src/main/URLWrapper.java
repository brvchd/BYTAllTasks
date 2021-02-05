package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLWrapper {
    private final URL url;
    private String urlPath;

    public URLWrapper(String url) throws MalformedURLException {
        this.url = new URL(url);
        urlPath=url;
    }

    public URLConnection openConnection() throws IOException {
        return url.openConnection();
    }

    public URL getURL() {
        return url;
    }

    public String getUrlPath() {
        return urlPath;
    }
}
