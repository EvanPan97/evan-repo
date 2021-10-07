package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "demo-provider")
public interface RemoteProviderService {
    @GetMapping("/provider/echo/{Msg}")
    String echoMsg(@PathVariable("Msg") String str);
}
