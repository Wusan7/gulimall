package com.wusan.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wusan.gulimall.coupon.entity.CouponEntity;
import com.wusan.gulimall.coupon.service.CouponService;
import com.wusan.common.utils.PageUtils;
import com.wusan.common.utils.R;



/**
 * 优惠券信息
 *
 * @author wusan
 * @email wusan1949@gmail.com
 * @date 2023-01-07 06:18:26
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;


    /**
     *
     * 想要获取当前会员领取到的所有优惠券。先去注册中心找优惠券服务，
     * 注册中心调一台优惠券服务器给会员，会员服务器发送请求给这台优
     * 惠券服务器，然后对方响应。
     *
     * @return  会员领取到的优惠券
     */
    @RequestMapping("/member/list")
    public R memberCoupons(){
        // 应该去数据库查用户对于的优惠券，但这个我们简化了，不去数据库查了，构造了一个优惠券给他返回
        CouponEntity coupon = new CouponEntity();
        //优惠券的名字
        coupon.setCouponName("满100减100");
        return R.ok().put("coupons", Collections.singleton(coupon));
    }

    /**
     * 列表
     */

    @RequestMapping("/list")
    //@RequiresPermissions("coupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:coupon:info")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:coupon:delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
