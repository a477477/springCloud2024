package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: lxf
 * @Date: 2024/5/24.
 */
@RestController
public class OrderController {

//  public static final String PaymenSrv_URL = "http://localhost:8001";//先写死，硬编码
    public static final String PaymenSrv_URL = "http://cloud-payment-service";//在服务注册中心上的微服务名称
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/comsumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymenSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping(value = "/comsumer/pay/del/{id}")
    public ResultData delId(@PathVariable("id")Integer  integer) {

        return restTemplate.postForObject(PaymenSrv_URL + "/pay/del/"+integer, integer, ResultData.class);
    }

    @GetMapping(value = "/comsumer/pay/update")
    public ResultData update(PayDTO payDTO) {
        return restTemplate.postForObject(PaymenSrv_URL + "/pay/update", payDTO, ResultData.class);
    }

    @GetMapping(value = "/comsumer/get/{id}")
    public ResultData getById(@PathVariable("id")Integer  integer) {
        return restTemplate.getForObject(PaymenSrv_URL + "/pay/get/"+integer, ResultData.class,integer);
    }
    @GetMapping(value = "/comsumer/getall")
    public ResultData getOrderAll(PayDTO payDTO) {
        return restTemplate.getForObject(PaymenSrv_URL + "/pay/getall", ResultData.class);
    }
    @GetMapping(value = "/comsumer/pay/get/info")
    public String getOrderByConsul() {
        return restTemplate.getForObject(PaymenSrv_URL + "/pay/get/info", String.class);
    }

    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/discovery")
    public String discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }
}
