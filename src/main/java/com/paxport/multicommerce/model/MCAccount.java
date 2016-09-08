package com.paxport.multicommerce.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.serial.Serial;
import org.immutables.value.Value;

import java.math.BigDecimal;

@Value.Immutable
@Serial.Structural
@JsonSerialize(as = ImmutableMCAccount.class)
@JsonDeserialize(as = ImmutableMCAccount.class)
public abstract class MCAccount {

    public enum Type {FUNDING,CARD}
    public enum State {ACTIVE,INACTIVE,CLOSED,DELETED}

    public abstract Long getId();
    public abstract String getProviderAccountId();
    public abstract MCOrganisation getOrganisation();
    public abstract String getCurrency();
    public abstract State getState();
    public abstract String getFriendlyName();
    public abstract BigDecimal getBalance();
    public abstract Type getAccountType();

}
