package com.tppproject.payment.processing;

import com.tppproject.payment.interestCalculator.IntradayInterest;
import com.tppproject.payment.interestCalculator.IntradayInterestImpl;
import com.tppproject.payment.parser.AccountParserContext;
import com.tppproject.payment.parser.BalanceParserContext;
import com.tppproject.payment.parser.JSONAccountParser;
import com.tppproject.payment.parser.JSONBalanceDataParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class PaymentProcessing {
    public static void main(String[] args) throws IOException, ParseException {
        //we can get the path from env variable also , right now i am takeing from loaction
        String createAccountString ="E:\\09-OCT-2021\\src\\main\\resources\\createAccountJSON.json";
        String consumeDataString = "E:\\09-OCT-2021\\src\\main\\resources\\balanceEnquery.json";
        // following Stretegy pattern so that in future Input data pattern get changed we need to do minimal
        // effor to consume
        AccountParserContext accountContext = new AccountParserContext(new JSONAccountParser());
        List createList = accountContext.parse(createAccountString);

        BalanceParserContext consumeDataContext = new BalanceParserContext(new JSONBalanceDataParser());
        List consumeDataList = consumeDataContext.consue(consumeDataString);

        IntradayInterest calculateData = new IntradayInterestImpl();
        Map<Long,BigDecimal> mapData = calculateData.calculateIntradayInterest(createList,consumeDataList);

        System.out.println("Put this data on Queue to notify Interest on account");



    }
}
