package com.atguigu.cloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @Author: lxf
 * @Date: 2024-06-04 22:16
 */
public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}
