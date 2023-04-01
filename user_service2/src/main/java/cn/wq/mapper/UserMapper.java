package cn.wq.mapper;

import cn.wq.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author chenchao
 * @Data 2023/3/29 11:30
 **/

public interface UserMapper {
    @Select("select * from tb_user where id= #{id}")
    User getUserById(Long id);
}