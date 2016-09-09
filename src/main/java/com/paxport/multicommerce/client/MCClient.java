package com.paxport.multicommerce.client;

import com.paxport.multicommerce.model.MCCredentials;

/**
 * Usage:
 *
 *  MCCredentials creds = MCCredentials.of(username,password);
 *  MCClient sessions = new MCClient();
 *  List<MCCard> cards = sessions.doInSession(s -> s.cards(),creds);
 *
 */
public class MCClient {

    public final static String PRODUCTION_URL = "https://portal.multicommerce.net/mpay2-service/";
    public final static String TEST_URL = "http://mpayqa0.test.mcom:8080/mpay2-service";

    private MCApiFactory clientFactory;

    public MCClient(MCApiFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public MCClient(String serviceUrl) {
        this(new MCApiFactory(serviceUrl));
    }

    public MCClient() {
        this(new MCApiFactory(PRODUCTION_URL));
    }

    public MCClient(boolean test) {
        this(new MCApiFactory(test?TEST_URL:PRODUCTION_URL));
    }

    public MCSession login(MCCredentials credentials) {
        MulticommerceAPI api = clientFactory.newClient();
        return new MCSession(api,credentials).login();
    }

    public <E> E doInSession(MCSessionJob<E> job, MCCredentials credentials) {
        MCSession session = login(credentials);
        try {
            return job.doInSession(session);
        }
        finally{
            session.logout();
        }
    }
}
