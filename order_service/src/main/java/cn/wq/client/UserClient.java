package cn.wq.client;

import cn.wq.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 86132
 */
@FeignClient("userservice")
public interface UserClient {
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable("id") Long id);
}
