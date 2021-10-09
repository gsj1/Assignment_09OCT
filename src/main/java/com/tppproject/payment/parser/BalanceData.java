package com.tppproject.payment.parser;

import com.tppproject.payment.model.BalenceEnquiry;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface BalanceData {
    public List<BalenceEnquiry> consumeBalanceData(String location) throws IOException, ParseException;
}
