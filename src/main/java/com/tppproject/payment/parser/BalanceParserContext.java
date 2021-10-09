package com.tppproject.payment.parser;

import com.tppproject.payment.model.BalenceEnquiry;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class BalanceParserContext {
    private final BalanceData balanceData;

    public BalanceParserContext(BalanceData balanceData) {
        this.balanceData = balanceData;
    }

    public List<BalenceEnquiry> consue(String location) throws IOException, ParseException {
       return( balanceData.consumeBalanceData(location));
    }
}
