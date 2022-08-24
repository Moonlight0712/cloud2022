package com.lay.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "maintenanceClient", url = "${feign.client.dd}" )
public interface IMaintenanceClient {
    @Async
    @GetMapping(value = "/WebServices/WeatherWebService.asmx")
    void refresh();


    @Async
    @GetMapping(value = "/data-daemon/maintenance/verification-code")
    void sendVerificationCode(@RequestHeader(value = "Authorization") String authorizationHeader, @RequestParam(value = "phoneNumber") String phoneNumber, @RequestParam(value = "manufacturers") List<String> manufacturers);

}
