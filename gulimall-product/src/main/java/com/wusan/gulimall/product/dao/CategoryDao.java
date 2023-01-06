package com.wusan.gulimall.product.dao;

import com.wusan.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author wusan
 * @email wusan1949@gmail.com
 * @date 2023-01-07 06:01:42
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
