package com.paxport.multicommerce.client;

import com.paxport.multicommerce.model.LoginCredentials;
import com.paxport.multicommerce.model.LoginResponse;

import feign.Headers;
import feign.RequestLine;

/**
 * Feign Client Interface
 */
public interface MulticommerceAPI {


    @RequestLine("POST /auth/login")
    @Headers("Content-Type: application/json")
    LoginResponse login(LoginCredentials credentials);


}
