package com.syhd.forward.user;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Configuration
public class UserAction {

    // spring内置,封装了http请求的工具类
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getuser/{uid}")
    @HystrixCommand(fallbackMethod="userFallbackMethod")
    public @ResponseBody  Map<String,Object> getUser(@PathVariable String uid) {
        // http://127.0.0.1:8080/sss
        // syhd-user 通过名称 找到负载均衡器，负载均衡器会选择一个具体的实例
        System.out.println("[user]通过ribbon请求了");
        return restTemplate.getForObject("http://syhd-user/user/getuser/"+uid, Map.class);
    }
    //熔断 措施 防止微服务调用链全面崩溃
    public @ResponseBody Map<String,Object> userFallbackMethod(String uid){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",200);
        map.put("status",500);
        map.put("message","微服务调用错误,服务名称[syhd-user],调用地址[/user/getuser/]");
        return map;
    }

}
