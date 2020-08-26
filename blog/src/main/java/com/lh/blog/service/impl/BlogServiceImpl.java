package com.lh.blog.service.impl;

import com.lh.blog.entity.Blog;
import com.lh.blog.mapper.BlogMapper;
import com.lh.blog.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
