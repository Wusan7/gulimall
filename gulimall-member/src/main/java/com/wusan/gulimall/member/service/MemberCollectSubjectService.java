package com.wusan.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wusan.common.utils.PageUtils;
import com.wusan.gulimall.member.entity.MemberCollectSubjectEntity;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author wusan
 * @email wusan1949@gmail.com
 * @date 2023-01-07 06:24:05
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

