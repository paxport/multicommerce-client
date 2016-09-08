package com.paxport.multicommerce.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.serial.Serial;
import org.immutables.value.Value;

import java.time.LocalDate;

import javax.annotation.Nullable;

@Value.Immutable
@Serial.Structural
@JsonSerialize(as = ImmutableMCCard.class)
@JsonDeserialize(as = ImmutableMCCard.class)
public abstract class MCCard {

    public enum CardType {
        MASTERCARD,
        DEBIT_MASTERCARD,
        VISA_CREDIT,
        VISA_DEBIT,
        VISA,
        SWITCH,
        AMERICAN_EXPRESS,
        DINERS_CLUB;
    }

    public enum FundType {
        PREPAID,
        CREDIT,
        DEBIT;
    }

    public abstract CardType getCardType();

    @Nullable
    public abstract CardType getUseAs();

    public abstract String getNameOnCard();

    public abstract String getCardNumber();

    public abstract String getCvv();

    @Nullable
    public abstract Integer getIssueNumber();

    @Nullable
    public abstract String getIssueDate();

    @Nullable
    public abstract String getExpiryDate();

    @Nullable
    public abstract String getFundingDate();

    @Nullable
    public abstract Integer getFundingBalance();

    @Nullable
    public abstract FundType getFundingType();

    @Nullable
    public abstract String getUsage();

    @Nullable
    public abstract String getCreatingSystem();

    @Nullable
    public abstract String getCardForm();

    @Nullable
    public abstract MCAccount getCardAccount();


}
