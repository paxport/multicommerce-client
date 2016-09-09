package com.paxport.multicommerce.client;


import java.util.ArrayList;
import java.util.List;

import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

/**
 * Factory for creating API Feign based instances
 *
 * You should only need to create one of these if you need to mess with the
 * request interceptors etc
 *
 * Instead just create an MCClient
 *
 */
public class MCApiFactory {

    protected List<RequestInterceptor> requestInterceptors = new ArrayList<>();

    protected String serviceUrl;

    public MCApiFactory(String serviceUrl){
        this.serviceUrl = serviceUrl;
    }

    public MulticommerceAPI newClient() {
        return buildApi();
    }

    protected MulticommerceAPI buildApi() {
        return Feign.builder()
                .logger(new Slf4jLogger(MulticommerceAPI.class))
                .logLevel(Logger.Level.FULL)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptors(requestInterceptors)
                .target(MulticommerceAPI.class, serviceUrl);
    }

    public List<RequestInterceptor> getRequestInterceptors() {
        return requestInterceptors;
    }
}
