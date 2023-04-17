package com.eatta.forex.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ForexAPIResponse {

    private MOTD motd;
    private String success;
    private String base;
    private String date;
    private Map<String, Double> rates;
}

@Getter
@Setter
class MOTD {
    private String msg;
    private String url;
}
