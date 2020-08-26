package com.lh.blog.service.impl;

import com.lh.blog.entity.User;
import com.lh.blog.mapper.UserMapper;
import com.lh.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuhui
 * @since 2020-06-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
