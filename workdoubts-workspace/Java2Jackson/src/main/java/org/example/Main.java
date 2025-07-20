package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ResponseData data1  = new ResponseData();

        /*Map<String,String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        ResponseData.Attributes attr = new ResponseData.Attributes();
        attr.setCustomMessages(map);

        ResponseData.Data d = new ResponseData.Data();
        d.setId("491");
        d.setType("info");
        d.setAttributes(attr);
        data1.setData(d);*/
        Map<String,String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        //Attributes attributes = data1.getAttributes();
        //attributes.setCustomMessages(map);
        data1.setId("491");
        data1.setType("info");
        //attributes.setCustomMessages(map);
        data1.setCustomMessages(map);
        String str = data1.toString();
        //System.out.println(JSONObject.stringToValue(str));
        ObjectMapper om = new ObjectMapper();

        try {

            // covert Java object to JSON strings
            String json = om.writeValueAsString(data1);

            // output: {"name":"mkyong","age":42}
            System.out.println(json);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}