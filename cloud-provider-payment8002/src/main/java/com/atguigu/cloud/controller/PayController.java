package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: lxf
 * @Date: 2024/5/21.
 */
@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping(value="/pay/add")
    @Operation(summary = "添加",description = "添加方法")
    public ResultData<String> addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        int add = payService.add(pay);
        return ResultData.success("成功插入记录，返回值"+add);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "delId",description = "delId")
    public  ResultData<Integer> deletePya(@PathVariable("id") Integer id){
        int delete = payService.delete(id);

        return ResultData.success(delete);
    }

    @PutMapping(value = "pay/update")
    @Operation(summary = "put",description = "put")
    public  ResultData<String>  updatePay(@RequestBody PayDTO payDTO)
    {

        Pay pay =new Pay();
        BeanUtil.copyProperties(payDTO,pay);
        int update = payService.update(pay);
        return ResultData.success("成功插入记录，返回值"+update);

    }
    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "getById2",description = "getById2")
    public  ResultData<Pay> getById(@PathVariable("id") Integer id){
        Pay byId = payService.getById(id);
        return  ResultData.success(byId);
    }

    @GetMapping(value = "/pay/getall")
    @Operation(summary = "all",description = "all")
    public  ResultData<List<Pay>>  getAll(){
        List<Pay> all = payService.getAll();
        return ResultData.success(all);
    }



    @GetMapping(value = "/pay/error")
    public  ResultData<Integer> getPayError(){
        Integer integer =Integer.valueOf(500);
        try {
            System.out.println("come in payerror test");
            int age =10/0;
        }catch (Exception e){
            e.printStackTrace();
            ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
        return  ResultData.success(integer);
    }

    @Value("${server.port}")
    private  String port;
    @GetMapping("/pay/get/info")
    private String getInfoByConsul(@Value("${info}") String atguiguInfo)
    {
        return "atguiguInfo: "+atguiguInfo+"\t"+"port: "+port;
    }
}
