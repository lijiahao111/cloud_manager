package cn.wq.service.impl;

import cn.wq.mapper.UserMapper;
import cn.wq.pojo.User;
import cn.wq.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author chenchao
 * @Data 2023/3/29 11:32
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper  userMapper;
    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }
}
