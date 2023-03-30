package cn.wq.security.user.controller;


import cn.wq.security.common.base.PlatformBaseController;
import cn.wq.security.detail.PersonDetail;
import cn.wq.security.user.entity.User;
import cn.wq.security.user.service.IUserService;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author autoGen
 * @since 2023-03-27
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController extends PlatformBaseController {

    private final IUserService userService;
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id ) throws JsonProcessingException {

        User user = userService.selectUserByParam(id);

        Authentication authentication = SecurityContextHolder .getContext().getAuthentication();
        PersonDetail principal =(PersonDetail) authentication.getPrincipal();
        String username = principal.getUsername();
        System.out.println("username = " + username);
        System.out.println("authentication = " + authentication);

        return JSONObject.toJSONString(user);

    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/root")
    String root(){
        return "success";
    }

}

