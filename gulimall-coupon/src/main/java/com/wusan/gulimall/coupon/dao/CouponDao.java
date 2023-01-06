package com.wusan.gulimall.coupon.dao;

import com.wusan.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author wusan
 * @email wusan1949@gmail.com
 * @date 2023-01-07 06:18:26
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
