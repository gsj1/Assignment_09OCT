package com.tppproject.payment.model;

public class BalenceEnquiry {

    String balanceDate;
    BalenceData[] balenceData;

    public String getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
    }

    public BalenceData[] getBalenceData() {
        return balenceData;
    }

    public void setBalenceData(BalenceData[] balenceData) {
        this.balenceData = balenceData;
    }
}
