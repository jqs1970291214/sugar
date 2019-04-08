package com.junqson.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @RestController
    static class ConsumerController {

        @Value("${greeting}")
        public String greet;


        @Autowired
        private LoadBalancerClient loadBalancerClient;

        @Autowired
        private DiscoveryClient discoveryClient;

        @Autowired
        private RestTemplate restTemplate;


        @GetMapping("/greeting")
        public String greeting() {
            return this.greet;
        }

        @GetMapping("/services")
        public List<String> getServices() {
            return discoveryClient.getServices();
        }

        @GetMapping("/producers")
        public String producer(String name) {
            return discover(name);
        }


        public String discover(String name) {
            ServiceInstance serviceInstance = loadBalancerClient.choose(name);
            if (serviceInstance != null) {
                return serviceInstance.getUri().toString();
            }
            return null;
        }

        @GetMapping("/provider/consume")
        public String consume(String id) {
            String uri = discover("service-producer") + "/contentservice/getid?id=" + id;
            System.out.println(uri);

            String response = restTemplate.getForObject(uri, String.class);
            if (response == null) {
                response = "";
            }
            return response + "--- consume";
        }


    }

}





