package com.tppproject.payment.parser;

import com.tppproject.payment.model.CreateNewAccount;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class AccountParserContext {
    private final NewAccountParser accountPArserContext;

    public AccountParserContext(NewAccountParser accountPArserContext) {
        this.accountPArserContext = accountPArserContext;
    }

    public List<CreateNewAccount> parse(String location) throws IOException, ParseException {
       return (accountPArserContext.consumeAccountPayload(location));
    }
}
