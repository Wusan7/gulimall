package com.wusan.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wusan.common.utils.PageUtils;
import com.wusan.gulimall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author wusan
 * @email wusan1949@gmail.com
 * @date 2023-01-07 06:01:42
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

