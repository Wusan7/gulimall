package com.wusan.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wusan.common.utils.PageUtils;
import com.wusan.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author wusan
 * @email wusan1949@gmail.com
 * @date 2023-01-07 06:01:42
 */
public interface CategoryService extends IService<CategoryEntity> {


    List<CategoryEntity> listWithTree();

    void deleteByIds(List<Long> asList);
}

