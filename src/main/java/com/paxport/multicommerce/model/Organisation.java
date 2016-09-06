package com.paxport.multicommerce.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.serial.Serial;
import org.immutables.value.Value;

import javax.annotation.Nullable;

@Value.Immutable
@Serial.Structural
@JsonSerialize(as = ImmutableOrganisation.class)
@JsonDeserialize(as = ImmutableOrganisation.class)
public abstract class Organisation {

    public enum Status {ACTIVE,DELETED,OTHER};

    @Nullable
    public abstract Integer getId();

    @Value.Parameter
    public abstract String getCode();

    @Value.Parameter
    public abstract String getName();

    @Value.Parameter
    public abstract Status getStatus();

    public static Organisation of (String code, String name, Status status) {
        return ImmutableOrganisation.of(code,name,status);
    }
}
