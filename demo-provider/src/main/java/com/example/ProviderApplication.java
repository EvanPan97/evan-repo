package com.example;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @RestController
    public class ProviderController {
        @Value("${server.port:8080}")
        private String server;

        /**
         * url = http://localhost:8081/provider/echo/{msg}
         *
         * @param msg
         * @return "localhost:8081 say {msg}"
         */
        @GetMapping("/provider/echo/{msg}")
        public String doRestDefaultEcho(@PathVariable String msg) {
            return server + " say " + msg;
        }
    }
}
