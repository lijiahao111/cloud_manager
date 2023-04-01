package cn.wq.client;

import cn.wq.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user_service")
public interface UserClient {
    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") Long id);
}
