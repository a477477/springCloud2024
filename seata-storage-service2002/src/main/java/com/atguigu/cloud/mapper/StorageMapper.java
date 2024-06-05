package com.atguigu.cloud.mapper;
import com.atguigu.cloud.entities.Storage;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
/**
 * @Author: lxf
 * @Date: 2024-06-04 22:05
 */
public interface StorageMapper extends Mapper<Storage>
{
    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);


}
