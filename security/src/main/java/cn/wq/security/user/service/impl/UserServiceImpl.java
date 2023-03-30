package cn.wq.security.user.service.impl;

import cn.wq.security.user.entity.User;
import cn.wq.security.user.mapper.UserMapper;
import cn.wq.security.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author autoGen
 * @since 2023-03-27
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private final UserMapper userMapper;

    @Override
    public User selectUserByParam(Long id) {
        return userMapper.selectUserByParam(id);
    }

}
