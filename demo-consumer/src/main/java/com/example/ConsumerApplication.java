package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RestController
    public class ConsumerController{
        @Value("${spring.application.name}")
        private String appName;

        @Resource
        private RestTemplate restTemplate;

        @GetMapping("/consumer/doRestEcho")
        public String doRestEcho(){
            String url = "http://localhost:8081/provider/echo/"+appName;
            // 获取访问url的返回结果
            return restTemplate.getForObject(url, String.class);
        }
    }
}
