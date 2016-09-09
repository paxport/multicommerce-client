package com.paxport.multicommerce.client;


import com.paxport.multicommerce.model.MCCard;
import com.paxport.multicommerce.model.MCCredentials;

import java.util.List;

public class MCSession {

    private MulticommerceAPI api;
    private MCCredentials credentials;
    private String token;

    // package access - should be created via session factory
    MCSession(MulticommerceAPI api, MCCredentials credentials) {
        this.api = api;
        this.credentials = credentials;
    }

    public MCSession login(){
        token = api.login(credentials).getToken();
        return this;
    }

    public List<MCCard> cards() {
        return api.cards(token);
    }

    public List<MCCard> lodgedCards() {
        return api.lodgedCards(token);
    }

    public MCSession logout(){
        api.logout(token);
        return this;
    }

}
