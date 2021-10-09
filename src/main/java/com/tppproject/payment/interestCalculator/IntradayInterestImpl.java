package com.tppproject.payment.interestCalculator;

import com.tppproject.payment.model.BalenceData;
import com.tppproject.payment.model.BalenceEnquiry;
import com.tppproject.payment.model.CreateNewAccount;

import java.math.BigDecimal;
import java.util.*;

public class IntradayInterestImpl implements IntradayInterest {
    @Override
    public Map<Long,BigDecimal> calculateIntradayInterest(List<CreateNewAccount> accountDetails, List<BalenceEnquiry> balanceDetails) {

        Map<Long,BigDecimal> accounInterest = new HashMap<Long,BigDecimal>();
        BigDecimal interestAmoutForAccount = new BigDecimal(0);
        //traverse the balanceDetails and calculate interest based on creation date in accountDetails
        for (BalenceEnquiry data : balanceDetails)
        {
            Map<Long,String> listOfAccount = new HashMap<Long,String>();
            //convert accountDetails to map with identification and openingDate so that it will load once
            for (CreateNewAccount createAccountdetails : accountDetails)
            {
                listOfAccount.put(createAccountdetails.getIdentification(),createAccountdetails.getOpeningDate());
            }
            //expecting that bank will send all details with one tag at end of day "balanceDate" : "2021-09-19"
            BalenceData[] balanceData = data.getBalenceData();
            //convert array to list to that is can use list functions
            List<BalenceData> listBalenceData =new ArrayList(Arrays.asList(balanceData));
            for (BalenceData balanceObject : listBalenceData)
            {
               if(listOfAccount.get(balanceObject.getIdentification()) !=null)
               {
                   //based on logic to calculate the interest for time duration
                   interestAmoutForAccount= balanceObject.getBalence();
                   accounInterest.put(balanceObject.getIdentification(),interestAmoutForAccount);
               }

            }

        }
        return accounInterest;

    }
}
