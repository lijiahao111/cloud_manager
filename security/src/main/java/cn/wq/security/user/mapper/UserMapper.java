package cn.wq.security.user.mapper;

import cn.wq.security.common.base.PlatformBaseMapper;
import cn.wq.security.user.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author autoGen
 * @since 2023-03-27
 */
public interface UserMapper extends PlatformBaseMapper<User> {


    @Select("select * from User where id=#{id}")
    User selectUserByParam(Long id);
}
