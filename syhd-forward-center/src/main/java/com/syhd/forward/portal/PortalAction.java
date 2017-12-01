package com.syhd.forward.portal;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/uportal")
@Configuration
public class PortalAction {

    // spring内置,封装了http请求的工具类
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private static final Logger logger=Logger.getLogger(PortalAction.class);

    @GetMapping("/getuser/{uid}")
    @HystrixCommand(fallbackMethod="uportFallbackMethod")
    public @ResponseBody  Map<String,Object> getUserInfo(@PathVariable String uid) {
        // http://127.0.0.1:8080/sss
        // syhd-user-uportal 通过名称 找到负载均衡器，负载均衡器会选择一个具体的实例
        logger.info("[uportal]通过ribbon请求了,地址[http://syhd-user-portal/uportal/getUserById/],参数{"+uid+"}");
        //http://10.10.1.179:8989/uportal/getuser/syhd01
        return restTemplate.getForObject("http://syhd-user-portal/uportal/getuser/"+uid, Map.class);
    }
    //熔断 措施 防止微服务调用链全面崩溃
    public @ResponseBody Map<String,Object> uportFallbackMethod(String uid){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",200);
        map.put("status",404);
        map.put("message","系统错误无法正常响应请求");
        map.put("message","微服务调用错误,服务名称[syhd-user-portal],调用地址[/uportal/getuser/]");
        return map;
    }

    @GetMapping(value = "/login",produces = "text/hmtl")
    public ResponseEntity<ModelAndView> login(HttpServletRequest request, HttpServletResponse response) {
        // http://127.0.0.1:8080/sss
        // syhd-user-uportal 通过名称 找到负载均衡器，负载均衡器会选择一个具体的实例
        logger.info("[uportal]通过ribbonq请求了,地址[http://syhd-user-portal/uportal/login/],参数{}");
        return  (ResponseEntity<ModelAndView>)restTemplate.getForEntity("http://syhd-user-uportal/uportal/login/", ModelAndView.class);
    }
}
