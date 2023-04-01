package cn.wq.web;

import cn.wq.pojo.User;
import cn.wq.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenchao
 * @Data 2023/3/29 11:33
 **/
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @GetMapping("/{id}")
    public User  getUserById(@PathVariable("id") Long id) {

        User userById = userService.getUserById(id);
        return userById;


    }
}
