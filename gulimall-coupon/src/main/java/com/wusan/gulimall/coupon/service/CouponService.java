package com.wusan.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wusan.common.utils.PageUtils;
import com.wusan.gulimall.coupon.entity.CouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author wusan
 * @email wusan1949@gmail.com
 * @date 2023-01-07 06:18:26
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

