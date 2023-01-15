package com.wusan.gulimall.product.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.wusan.gulimall.product.dao.CategoryDao;
import com.wusan.gulimall.product.entity.CategoryEntity;
import com.wusan.gulimall.product.service.CategoryService;

/**
 *
 * 先收集一级菜单
 *
 * @date
 * @author wusan
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {



        /**
     * TODO 三级分类组装树形结构
     * 1.查出所有一级菜单 父分类等于0表示为一级菜单
     * 2.在entity类中添加List<Children>属性 用于封装后续的子菜单 @TableField(exist = false) 数据库中没有此字段
     * 3.递归查找所有子菜单  所有菜单 如果all菜单父id == rootId 那么此菜单就是root子菜单
     * @return
     */
    public List<CategoryEntity> listWithTree() {
        //查出所有菜单
        List<CategoryEntity> categoryEntityList = baseMapper.selectList(null);
        //查出所有一级菜单 父分类等于0表示为一级菜单
        return categoryEntityList.stream().filter(categoryEntity ->
                        categoryEntity.getParentCid() == 0
                //树形菜单返回之前 使用map方式设置子菜单
        ).map((menu) -> {
            //menus 当前菜单  categoryEntityList 所有菜单
            menu.setChildren(getChildren(menu, categoryEntityList));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteByIds(List<Long> asList) {
        //todo 要检查是否被引用  没有被引用才能删除
        baseMapper.deleteBatchIds(asList);
    }



    /**
     * 递归查找所有子菜单
     *
     * @param root 当前菜单
     * @param all  所有菜单 如果all菜单父id == rootId 那么此菜单就是root子菜单
     * @return
     *
     * 递归是函数体中调用自己，如果不加控制，将无休止的调用自己，直到堆栈溢出。
     * 循环是反复执行某一段区域内的代码，如果不加控制，就会形成死循环。
     * 所以不管是递归还是循环，都要设定一定的条件，以结束递归或循环。
     *
     *
     *     //TODO 回来继续写  filter是过滤，map是对数据进行修改
     *     //filter先过滤出来root菜单的下级菜单，然后map里把当前子菜单设置进当前root菜单的children属性（子菜单）
     *     //sorted 排序 java只要涉及排序，一个是自然排序，另外是自定义排序 就这两个
     *     //collect 终止操作
     *
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity -> {
            categoryEntity.setChildren(getChildren(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

    }

}






































































