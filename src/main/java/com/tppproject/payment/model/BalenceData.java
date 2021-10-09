package com.tppproject.payment.model;

import java.math.BigDecimal;

public class BalenceData {


    String bsb;
    long identification;
    BigDecimal balence;

    public String getBsb() {
        return bsb;
    }

    public void setBsb(String bsb) {
        this.bsb = bsb;
    }

    public long getIdentification() {
        return identification;
    }

    public void setIdentification(long identification) {
        this.identification = identification;
    }

    public BigDecimal getBalence() {
        return balence;
    }

    public void setBalence(BigDecimal balence) {
        this.balence = balence;
    }
}
