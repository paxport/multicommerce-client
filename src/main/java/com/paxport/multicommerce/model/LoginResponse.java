package com.paxport.multicommerce.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.serial.Serial;
import org.immutables.value.Value;

import javax.annotation.Nullable;

@Value.Immutable
@Serial.Structural
@JsonSerialize(as = ImmutableLoginResponse.class)
@JsonDeserialize(as = ImmutableLoginResponse.class)
public interface LoginResponse {

    enum Status {SUCCESS,FAILURE,OTHER}

    Status getStatus();

    @Nullable
    String getToken();

    String getInvokingSystem();

    @Nullable
    String getTrackingId();

    @Nullable
    User getUser();

    @Nullable
    Organisation getEffectiveOrganisation();

}
