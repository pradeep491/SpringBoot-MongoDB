package org.example;

import lombok.Data;

import java.util.Map;

@Data
public class ResponseData {
    /*private Data data;

    @lombok.Data
    public static class Data {
        private String id;
        private String type;
        private Attributes attributes;
    }

    @lombok.Data
    public static class Attributes {
        //@JsonProperty("customMessages")
        private Map<String, String> customMessages;
    }*/

    private String id;
    private String type;
    //private Attributes attributes;
    //@JsonProperty("customMessages")
    private Map<String, String> customMessages;

}
