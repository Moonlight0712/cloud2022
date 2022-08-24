package com.lay.springcloud.controller;

import com.lay.springcloud.service.IMaintenanceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("assetManagement")
public class AssetManagementController {


    private final String AUTH_TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEQ01BQyIsImFwcElkIjoiRENNQUMiLCJleHAiOjQ3NzcxNzU5MjksImlhdCI6MTYyMTUwMjMyOX0.NyxiDj-sjyrAbx_feM9One9qPK0byiIemzjhsf3nRHE";
    @Autowired
    IMaintenanceClient maintenanceClient;

    @RequestMapping(value = "getCode")
    public String getCode() {

        maintenanceClient.refresh();

        return "ok";
    }


}

