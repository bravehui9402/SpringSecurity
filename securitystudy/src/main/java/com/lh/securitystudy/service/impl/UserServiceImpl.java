package com.lh.securitystudy.service.impl;

import com.lh.securitystudy.entity.User;
import com.lh.securitystudy.mapper.UserMapper;
import com.lh.securitystudy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lh
 * @since 2020-06-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
