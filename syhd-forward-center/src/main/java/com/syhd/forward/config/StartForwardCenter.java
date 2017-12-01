package com.syhd.forward.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableFeignClients  // @FeignClient(value = "hap-user-admin-service", fallback = OrganizationLabelFeignClientFallback.class) 支持此种方式调用需要开启此注解
@ComponentScan({"com.syhd.forward.portal","com.syhd.forward.user"})
@EnableHystrix //开启熔断
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableCircuitBreaker //少这个报的unable to connect错误
@EnableTurbine  //使用Turbine做性能监控
public class StartForwardCenter {

    public static void main(String[] args) {

        new SpringApplicationBuilder(StartForwardCenter.class).web(true).run(args);
    }


    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    @LoadBalanced// 这个注解一定要加，不然LoadBalancerAutoConfiguration不会对它进行处理
    public RestTemplate restTemplate() {
        return builder.build();
    }

}
