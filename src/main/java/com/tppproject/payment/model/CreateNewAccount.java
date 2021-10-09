package com.tppproject.payment.model;

public class CreateNewAccount {

    String bsb;
    long identification;
    String openingDate;

    public CreateNewAccount(String bsb, long identification, String openingDate) {
        this.bsb = bsb;
        this.identification = identification;
        this.openingDate = openingDate;
    }

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

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }
}
