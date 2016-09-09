package com.paxport.multicommerce.client;

import com.paxport.multicommerce.model.MCCard;
import com.paxport.multicommerce.model.MCCredentials;
import com.paxport.multicommerce.model.MCLogin;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * Feign Client Interface
 */
public interface MulticommerceAPI {


    @RequestLine("POST /auth/login")
    @Headers("Content-Type: application/json")
    MCLogin login(MCCredentials credentials);

    @RequestLine("GET /auth/logout?token={token}")
    @Headers({
            "Content-Type: application/json",
    })
    MCLogin logout(@Param("token") String token);


    @RequestLine("GET /cards/lodged")
    @Headers({
            "Content-Type: application/json",
            "X-Auth-Token: {token}"
    })
    List<MCCard> lodgedCards(@Param("token") String token);

    @RequestLine("GET /cards")
    @Headers({
            "Content-Type: application/json",
            "X-Auth-Token: {token}"
    })
    List<MCCard> cards(@Param("token") String token);

}
