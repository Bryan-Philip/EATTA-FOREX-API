package com.eatta.forex.web;

import com.eatta.forex.data.dto.ForexAPIResponse;
import com.eatta.forex.data.dto.ForexDTO;
import com.eatta.forex.service.ForexAPI;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class EATTAForexController {


    public static final String DEFAULT_BASE = "USD";
    private final ForexAPI forexAPI;

    public EATTAForexController(ForexAPI forexAPI) {
        this.forexAPI = forexAPI;
    }

    @GetMapping
    public String getForexRates(Model model, @RequestParam @Nullable String base) {
        try {
            ForexAPIResponse forexAPIResponse = forexAPI.callForexAPI(base == null ? DEFAULT_BASE : base);
            Map<String, Double> rates = forexAPIResponse.getRates();
            System.out.println("rates >>>" + rates.keySet());
            List<ForexDTO> forexDTOList = new ArrayList<>();
            rates.keySet().forEach(e -> {
                System.out.println("Base: " + base + ", Currency: " + e + ", Rate: " + rates.get(e));
                forexDTOList.add(new ForexDTO(base == null ? DEFAULT_BASE : base, e, rates.get(e)));
            });
            model.addAttribute("rates", forexDTOList);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "index";
    }


}

