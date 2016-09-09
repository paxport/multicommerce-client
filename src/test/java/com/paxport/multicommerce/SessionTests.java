package com.paxport.multicommerce;


import com.paxport.multicommerce.client.MCApiFactory;
import com.paxport.multicommerce.client.MCClient;
import com.paxport.multicommerce.model.MCCard;
import com.paxport.multicommerce.model.MCCredentials;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SessionTests {


    private String username = System.getProperty("mc-user","tester");
    private String password = System.getProperty("mc-pass","Password123");
    private String url = System.getProperty("mc-url", MCClient.TEST_URL);

    @Test
    public void lodgedCardsTest() {

        MCCredentials creds = MCCredentials.of(username,password);
        MCClient client = new MCClient(url);
        List<MCCard> cards = client.doInSession(s -> s.lodgedCards(),creds);
        Assert.assertNotNull(cards);
        Assert.assertFalse(cards.isEmpty());
    }

    @Test
    public void allCardsTest() {
        MCCredentials creds = MCCredentials.of(username,password);
        MCClient client = new MCClient(url);
        List<MCCard> cards = client.doInSession(s -> s.cards(),creds);
        Assert.assertNotNull(cards);
        Assert.assertFalse(cards.isEmpty());
    }

}
