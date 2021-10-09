package com.tppproject.payment.parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.tppproject.payment.model.CreateNewAccount;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONAccountParser implements NewAccountParser {
    List<CreateNewAccount> newAccountList = new LinkedList<CreateNewAccount>();
    public List<CreateNewAccount> consumeAccountPayload(String location) throws IOException, ParseException {
        //in practicle Scenario we will get this info from JMS but right now i am using through file to execute my scenario
        //Object obj = new JSONParser().parse(new FileReader(location));
        Object obj = new JSONParser().parse(new FileReader("E:\\09-OCT-2021\\src\\main\\resources\\createAccountJSON.json"));
        JSONObject jo = (JSONObject) obj;
        // getting bsb and identification and creation date
        String bsb = (String) jo.get("bsb");
        long identification = (long) jo.get("identification");
        String openingDate = (String)jo.get("openingDate");

        CreateNewAccount createAccountData= new CreateNewAccount(bsb,identification,openingDate);
        newAccountList.add(createAccountData);
        //persist the data to DB
        System.out.println("Create Account data persisted with data");

        return newAccountList;
    }
}
