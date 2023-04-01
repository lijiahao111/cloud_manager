package cn.wq.service;

import cn.wq.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author chenchao
 * @Data 2023/3/29 11:31
 **/
public interface UserService {

    User getUserById(Long id);
}
