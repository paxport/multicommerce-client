package com.paxport.multicommerce;

import com.paxport.multicommerce.client.MulticommerceAPI;
import com.paxport.multicommerce.client.MulticommerceClientFactory;
import com.paxport.multicommerce.model.MCCredentials;
import com.paxport.multicommerce.model.MCLogin;

import org.junit.Assert;
import org.junit.Test;

public class LoginTest {

    private String username = System.getProperty("mc-user","tester");
    private String password = System.getProperty("mc-pass","Password123");

    @Test
    public void loginTest() {

        MulticommerceClientFactory factory = new MulticommerceClientFactory();
        MulticommerceAPI client = factory.newTestClient();

        MCCredentials creds = MCCredentials.of(username,password);
        MCLogin login = client.login(creds);
        Assert.assertNotNull(login.getToken());
    }

}
