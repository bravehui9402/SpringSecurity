package com.lh.blog.mapper;

import com.lh.blog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuhui
 * @since 2020-06-23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
