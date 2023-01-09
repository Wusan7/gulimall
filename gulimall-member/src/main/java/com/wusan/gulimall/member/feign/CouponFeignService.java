package com.wusan.gulimall.member.feign;

import com.wusan.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * gulimall-coupon:nacos中注册的服务名字
 *
 * @author wusan
 * @date 2023/1/10 1:42
 */

@FeignClient("gulimall-coupon")
public interface CouponFeignService {


    /**
     *告诉spring cloud这个接口是一个远程客户端，要调用coupon服务，再去调用coupon服务/coupon/coupon/member/list对应的方法
     * @return
     */
    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();

}
