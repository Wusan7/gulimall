package com.wusan.gulimall.order.dao;

import com.wusan.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author wusan
 * @email wusan1949@gmail.com
 * @date 2023-01-07 06:26:08
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
