package com.example.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/ ")
public class FeignConsumerController {
    @Resource
    private RemoteProviderService remoteProviderService;

    /**
     * 基于feign方式的服务调用
     */
    @GetMapping("/echo/{msg}")
    public String doFeignEcho(@PathVariable String msg) {
        return remoteProviderService.echoMsg(msg);
    }
}
