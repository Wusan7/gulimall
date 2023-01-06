package com.wusan.gulimall.member.dao;

import com.wusan.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author wusan
 * @email wusan1949@gmail.com
 * @date 2023-01-07 06:24:05
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
