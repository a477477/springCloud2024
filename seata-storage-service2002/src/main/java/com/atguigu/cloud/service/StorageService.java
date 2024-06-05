package com.atguigu.cloud.service;

/**
 * @Author: lxf
 * @Date: 2024-06-04 22:07
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
