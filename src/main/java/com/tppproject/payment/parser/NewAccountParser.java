package com.tppproject.payment.parser;

import com.tppproject.payment.model.CreateNewAccount;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface NewAccountParser {
    public List<CreateNewAccount> consumeAccountPayload(String location) throws IOException, ParseException;


}
