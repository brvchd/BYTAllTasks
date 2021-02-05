package main;

import org.junit.Test;
import org.mockito.Mock;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SubscriptionManagerTest {

    @Mock
    URLConnection urlConnection = mock(URLConnection.class);

    @Mock
    URLWrapper url = mock(URLWrapper.class);

    @Test
    public void check() throws IOException {

        Date expected = new Date(2);

        when(urlConnection.getLastModified()).thenReturn(expected.getTime());

        when(url.getURL()).thenReturn(new URL("https://github.com"));

        when(url.openConnection()).thenReturn(urlConnection);

        SubscriptionManager subscriptionManager = new SubscriptionManager(url);

        assertNotNull(subscriptionManager);
        User user = new User();
        subscriptionManager.addObserver(user);

        subscriptionManager.check();
        assertEquals(expected.toString(), user.getMessage() );

    }
}