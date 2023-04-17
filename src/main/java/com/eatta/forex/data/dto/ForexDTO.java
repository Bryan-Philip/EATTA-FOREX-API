package com.eatta.forex.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ForexDTO {
    private String base;
    private String currency;
    private Double rate;
}
