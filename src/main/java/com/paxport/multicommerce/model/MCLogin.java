package com.paxport.multicommerce.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.serial.Serial;
import org.immutables.value.Value;

import javax.annotation.Nullable;

@Value.Immutable
@Serial.Structural
@JsonSerialize(as = ImmutableMCLogin.class)
@JsonDeserialize(as = ImmutableMCLogin.class)
public interface MCLogin {

    enum Status {SUCCESS,FAILURE,OTHER}

    Status getStatus();

    @Nullable
    String getToken();

    String getInvokingSystem();

    @Nullable
    String getTrackingId();

    @Nullable
    MCUser getUser();

    @Nullable
    MCOrganisation getEffectiveOrganisation();

}
