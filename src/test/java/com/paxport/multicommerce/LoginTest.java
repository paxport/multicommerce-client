package com.paxport.multicommerce;

import com.paxport.multicommerce.client.MulticommerceAPI;
import com.paxport.multicommerce.client.MulticommerceClientFactory;
import com.paxport.multicommerce.model.LoginCredentials;
import com.paxport.multicommerce.model.LoginResponse;

import org.junit.Test;

public class LoginTest {

    private String username = System.getProperty("mc-user");
    private String password = System.getProperty("mc-pass");


    @Test
    public void loginTest() {

        MulticommerceClientFactory factory = new MulticommerceClientFactory();
        MulticommerceAPI client = factory.newTestClient();

        LoginCredentials creds = LoginCredentials.of(username,password);

        LoginResponse login = client.login(creds);

    }

}
