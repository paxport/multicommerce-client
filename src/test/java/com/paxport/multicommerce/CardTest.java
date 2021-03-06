package com.paxport.multicommerce;


import com.paxport.multicommerce.client.MCClient;
import com.paxport.multicommerce.client.MulticommerceAPI;
import com.paxport.multicommerce.client.MCApiFactory;
import com.paxport.multicommerce.model.MCCard;
import com.paxport.multicommerce.model.MCCredentials;
import com.paxport.multicommerce.model.MCLogin;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CardTest {


    private String username = System.getProperty("mc-user","tester");
    private String password = System.getProperty("mc-pass","Password123");
    private String url = System.getProperty("mc-url", MCClient.TEST_URL);

    @Test
    public void lodgedCardsTest() {

        MCApiFactory factory = new MCApiFactory(url);
        MulticommerceAPI client = factory.newClient();

        MCCredentials creds = MCCredentials.of(username,password);
        MCLogin login = client.login(creds);

        List<MCCard> cards = client.lodgedCards(login.getToken());

        client.logout(login.getToken());

        Assert.assertNotNull(cards);
        Assert.assertFalse(cards.isEmpty());
    }

    @Test
    public void allCardsTest() {

        MCApiFactory factory = new MCApiFactory(url);
        MulticommerceAPI client = factory.newClient();

        MCCredentials creds = MCCredentials.of(username,password);
        MCLogin login = client.login(creds);

        List<MCCard> cards = client.cards(login.getToken());

        client.logout(login.getToken());

        Assert.assertNotNull(cards);
        Assert.assertFalse(cards.isEmpty());
    }

}
