package com.paxport.multicommerce.client;


import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

public class MulticommerceClientFactory {

    public final static String TEST_ROOT = "http://mpayqa0.test.mcom:8080/mpay2-service";

    public MulticommerceAPI newClient(String serviceUrl) {
        return Feign.builder()
                .logger(new Slf4jLogger(MulticommerceAPI.class))
                .logLevel(Logger.Level.FULL)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(MulticommerceAPI.class, serviceUrl);
    }

    public MulticommerceAPI newTestClient() {
        return newClient(TEST_ROOT);
    }

}
