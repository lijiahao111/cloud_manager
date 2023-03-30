package cn.wq.security.user.service;

import cn.wq.security.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author autoGen
 * @since 2023-03-27
 */
public interface IUserService extends IService<User> {
    User selectUserByParam(Long id);
}
