package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * @Author: lxf
 * @Date: 2024/5/21.
 */
public interface PayService {

    int add(Pay pay);
    int delete (Integer id);
    int update (Pay pay);
    List<Pay>  getAll();
    Pay  getById(Integer id);
}
