package com.paxport.multicommerce.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.serial.Serial;
import org.immutables.value.Value;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

import javax.annotation.Nullable;

@Value.Immutable
@Serial.Structural
@JsonSerialize(as = ImmutableUser.class)
@JsonDeserialize(as = ImmutableUser.class)
public abstract class User {

    public enum Status {ACTIVE,INACTIVE,PASSWORD_EXPIRED}

    @Nullable
    public abstract Integer getId();

    public abstract String getUsername();

    @Nullable
    public abstract String getFirstName();

    @Nullable
    public abstract String getLastName();

    @Nullable
    public abstract String getEmail();

    @Nullable
    public abstract Status getStatus();

    @Nullable
    public abstract String getPasswordUpdatedOn();

    @Nullable
    public abstract Organisation getOrganisation();

    @Nullable
    public abstract List<String> getRoles();


}
