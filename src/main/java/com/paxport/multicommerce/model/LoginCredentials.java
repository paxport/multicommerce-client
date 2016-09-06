package com.paxport.multicommerce.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.serial.Serial;
import org.immutables.value.Value;

import javax.annotation.Nullable;

@Value.Immutable
@Serial.Structural
@JsonSerialize(as = ImmutableLoginCredentials.class)
@JsonDeserialize(as = ImmutableLoginCredentials.class)
public abstract class LoginCredentials {

    @Value.Parameter
    public abstract String getUsername();

    @Value.Parameter
    public abstract String getPassword();

    @Nullable
    public abstract String getTrackingId();

    public static LoginCredentials of(String username, String password) {
        return ImmutableLoginCredentials.of(username,password);
    }

}
