package com.testProject.collectionsTest;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import com.tppproject.payment.interestCalculator.IntradayInterest;
import com.tppproject.payment.interestCalculator.IntradayInterestImpl;
import com.tppproject.payment.model.BalenceData;
import com.tppproject.payment.model.BalenceEnquiry;
import com.tppproject.payment.model.CreateNewAccount;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListTest {

    @Test
    public void testAssertList()
    {
        List<CreateNewAccount> listOfAccount = new LinkedList<CreateNewAccount>();
        List<BalenceEnquiry> listOfProcessingData =new LinkedList<BalenceEnquiry>();;
        CreateNewAccount newAccount = new CreateNewAccount ("182182",111222333, "2021-09-13");
        listOfAccount.add(newAccount);
        //data1
        BalenceData balanceobject1 = new BalenceData();
        balanceobject1.setIdentification(111222333);
        balanceobject1.setBsb("182182");
        balanceobject1.setBalence(new BigDecimal(123.34));

        //Data2
        BalenceData balanceobject2 = new BalenceData();
        balanceobject2.setIdentification(222000111);
        balanceobject2.setBsb("182182");
        balanceobject2.setBalence(new BigDecimal(12.34));

        //Data3
        BalenceData balanceobject3 = new BalenceData();
        balanceobject2.setIdentification(222000999);
        balanceobject2.setBsb("182182");
        balanceobject2.setBalence(new BigDecimal(0.0));

        BalenceData[] colectionOfData = new  BalenceData[] {balanceobject1,balanceobject2,balanceobject3};
        BalenceEnquiry  balanceEnquiry = new BalenceEnquiry();
        balanceEnquiry.setBalanceDate("2021-09-19");
        balanceEnquiry.setBalenceData(colectionOfData);

        listOfProcessingData.add(balanceEnquiry);

        IntradayInterest calculateData = new IntradayInterestImpl();
        Map<Long,BigDecimal> actualData = calculateData.calculateIntradayInterest(listOfAccount,listOfProcessingData);

        Map<Long,BigDecimal> expected = new HashMap<Long,BigDecimal>();
        expected.put(111222333L,new BigDecimal(123.34));


        assertEquals(actualData,expected);

    }
}
