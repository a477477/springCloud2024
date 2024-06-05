package com.atguigu.cloud.exp;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: lxf
 * @Date: 2024/5/23.
 */
//@Slf4j
//@RestControllerAdvice
//public class ClobalExceptionHandler {
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResultData<String> execption(Exception e){
//        System.out.println("========================= ClobalExceptionHandler ");
//        log.error("全局异常信息",e.getMessage(),e);
//        return  ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
//    }
//}
