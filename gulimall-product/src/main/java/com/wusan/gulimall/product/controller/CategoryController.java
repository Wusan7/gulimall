package com.wusan.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wusan.gulimall.product.entity.CategoryEntity;
import com.wusan.gulimall.product.service.CategoryService;
import com.wusan.common.utils.PageUtils;
import com.wusan.common.utils.R;



/**
 * 商品三级分类
 *
 * @author wusan
 * @email wusan1949@gmail.com
 * @date 2023-01-07 06:01:42
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    /**
     * 树形结构的三级菜单menu
     * 列表
     */
    @RequestMapping("/listWithTree")
    public R list(){
        List<CategoryEntity> list = categoryService.listWithTree();

        return R.ok().put("data", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);
        System.out.println(category.toString());
        return R.ok();
    }

    /**
     * 删除
     *
     * RequestBody 主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；
     * 只有post请求才有请求体 所以这其实是一个post请求
     *
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
//		categoryService.removeByIds(Arrays.asList(catIds));

        System.out.println(Arrays.toString(catIds));

        categoryService.deleteByIds(Arrays.asList(catIds));
        return R.ok();
    }

}











