package com.paxport.multicommerce.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.serial.Serial;
import org.immutables.value.Value;

import javax.annotation.Nullable;

@Value.Immutable
@Serial.Structural
@JsonSerialize(as = ImmutableMCCredentials.class)
@JsonDeserialize(as = ImmutableMCCredentials.class)
public abstract class MCCredentials {

    @Value.Parameter
    public abstract String getUsername();

    @Value.Parameter
    public abstract String getPassword();

    @Nullable
    public abstract String getTrackingId();

    public static MCCredentials of(String username, String password) {
        return ImmutableMCCredentials.of(username,password);
    }

}
