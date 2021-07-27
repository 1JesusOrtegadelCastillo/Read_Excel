package com.example.ReadFromExcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Map;
import java.util.TreeMap;

@Controller
public class GoogleChartRestController {

    @GetMapping("/chart")
    public String getPieChart(Model model) {
        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("A", 96);
        graphData.put("B", 87);
        graphData.put("C", 75);
        model.addAttribute("chartData", graphData);
        return "google-charts";
    }
}
