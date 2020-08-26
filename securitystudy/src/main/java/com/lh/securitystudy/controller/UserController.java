package com.lh.securitystudy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lh.securitystudy.common.Result;
import com.lh.securitystudy.entity.User;
import com.lh.securitystudy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lh
 * @since 2020-06-24
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    //用戶信息展示
    @GetMapping("users")
    public Result users(Integer currentPage){
        if(currentPage == null || currentPage <1 ) currentPage = 1 ;
        Page page  =new Page(currentPage,10);
        IPage users = userService.page(page, new QueryWrapper<User>().orderByAsc("ID"));
        return Result.succ(users);
    }
    //添加用户
    @PostMapping("edit")
    public Result addUser(@RequestBody User user){
        log.info("AddUser Controller get UserInfo : " + user.toString());
        if(user != null ){
            boolean b = userService.saveOrUpdate(user);
            if (b) return Result.succ("创建成功");
        }else {
            return  Result.fail("500","别开玩笑");
        }
        return Result.fail("500","发生异常了！");
    }
}
