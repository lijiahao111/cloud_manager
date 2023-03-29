package cn.wq.service.impl;

import cn.wq.mapper.OrderMapper;
import cn.wq.pojo.Order;
import cn.wq.pojo.User;
import cn.wq.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenchao
 * @Data 2023/3/29 12:00
 **/
@Service
@RequiredArgsConstructor
public class OrderServiceImpl  implements OrderService {

    private final OrderMapper orderMapper;
    private final RestTemplate restTemplate;
    @Override
    public Order gerOrderByid(Long id) {
        Order order = orderMapper.gerOrder(id);
        Long user_id = order.getUser_id();
        User forObject = restTemplate.getForObject("http://localhost:5000/user/" + user_id, User.class);
        order.setUser(forObject);
        return order;
    }
}
