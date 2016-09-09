package com.paxport.multicommerce.client;

public interface MCSessionJob<E> {
    E doInSession(MCSession session);
}
