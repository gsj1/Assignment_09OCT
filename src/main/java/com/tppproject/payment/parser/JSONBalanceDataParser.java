package com.tppproject.payment.parser;

import com.tppproject.payment.model.BalenceData;
import com.tppproject.payment.model.BalenceEnquiry;
import com.tppproject.payment.model.CreateNewAccount;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JSONBalanceDataParser implements BalanceData {
    List<BalenceEnquiry> balanceEnqList = new LinkedList<BalenceEnquiry>();
    List<BalenceData> balanceDataList = new LinkedList<BalenceData>();
    @Override
    public List<BalenceEnquiry> consumeBalanceData(String location) throws IOException, ParseException {

        BalenceEnquiry balenceEnquiryObject = new BalenceEnquiry();
        //in practicle Scenario we will get this info from JMS but right now i am using through file to execute my scenario
        Object obj = new JSONParser().parse(new FileReader(location));
        JSONObject jo = (JSONObject) obj;
        // getting balanceDate and other balance data
        String balanceDate = (String) jo.get("balanceDate");
        JSONArray ja = (JSONArray) jo.get("balance");
        // iterating balanceArray
        Iterator iterator = ja.iterator();
        Iterator<Map.Entry> iteratorOver=((Map) iterator.next()).entrySet().iterator();
        BalenceData balanceData = new BalenceData();
        while (iteratorOver.hasNext()) {
            Map.Entry pair = iteratorOver.next();
            {
                System.out.println(pair.getKey() + " : " + pair.getValue());

                if ("bsb".equals(pair.getKey())) {
                    balanceData.setBsb(pair.getValue().toString());
                }
                if ("identification".equals(pair.getKey())) {
                    balanceData.setIdentification(Long.parseLong(pair.getValue().toString()));
                }
                if ("balance".equals(pair.getKey())) {
                    balanceData.setBalence(new BigDecimal(pair.getValue().toString()));
                }
            }
        }
        balanceDataList.add(balanceData);
        balenceEnquiryObject.setBalanceDate(balanceDate);
        BalenceData[] itemsArray = new BalenceData[balanceDataList.size()];
        balenceEnquiryObject.setBalenceData(balanceDataList.toArray(itemsArray));
        balanceEnqList.add(balenceEnquiryObject);
        return balanceEnqList;
    }

}
