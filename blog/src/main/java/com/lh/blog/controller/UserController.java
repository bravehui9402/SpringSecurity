package com.lh.blog.controller;


import com.lh.blog.entity.User;
import com.lh.blog.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuhui
 * @since 2020-06-23
 */
@RestController
@Log
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/{id}")
    public Object test(@PathVariable("id") Long id) {
        log.info("start ...");
        return userService.getById(id);
    }


    /**
     * 测试实体校验
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Object testUser(@Validated @RequestBody User user) {
        return user.toString();
    }

}
