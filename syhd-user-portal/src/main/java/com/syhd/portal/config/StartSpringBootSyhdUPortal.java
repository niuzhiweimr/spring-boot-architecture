package com.syhd.portal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author niuzhiwei
 *		用户管理服务
 */
@EnableDiscoveryClient //服务注册发现
@SpringBootApplication
// 在不同包的情況下springboot必须要配置扫描
@ComponentScan(basePackages = { "com.syhd.portal.*" })
// 扫描mapper映射器
@MapperScan("com.syhd.portal.mapper")
public class StartSpringBootSyhdUPortal {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate () {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
        //TODO there can do some for request
        return restTemplate;

    }
	// 线程可见
	public static void main(String[] args) {
		SpringApplication.run(StartSpringBootSyhdUPortal.class, args);
	}


}
