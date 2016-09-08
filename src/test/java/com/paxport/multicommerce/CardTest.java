package com.paxport.multicommerce;


import com.paxport.multicommerce.client.MulticommerceAPI;
import com.paxport.multicommerce.client.MulticommerceClientFactory;
import com.paxport.multicommerce.model.MCCard;
import com.paxport.multicommerce.model.MCCredentials;
import com.paxport.multicommerce.model.MCLogin;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CardTest {


    private String username = System.getProperty("mc-user","tester");
    private String password = System.getProperty("mc-pass","Password123");

    @Test
    public void lodgedCardsTest() {

        MulticommerceClientFactory factory = new MulticommerceClientFactory();
        MulticommerceAPI client = factory.newTestClient();

        MCCredentials creds = MCCredentials.of(username,password);
        MCLogin login = client.login(creds);

        List<MCCard> cards = client.lodgedCards(login.getToken());

        Assert.assertNotNull(cards);
    }

}
