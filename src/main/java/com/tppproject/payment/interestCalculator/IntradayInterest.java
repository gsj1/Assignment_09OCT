package com.tppproject.payment.interestCalculator;

import com.tppproject.payment.model.BalenceEnquiry;
import com.tppproject.payment.model.CreateNewAccount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IntradayInterest {
    public Map<Long,BigDecimal> calculateIntradayInterest(List<CreateNewAccount> accountDetails, List<BalenceEnquiry> balanceDetails);
}
