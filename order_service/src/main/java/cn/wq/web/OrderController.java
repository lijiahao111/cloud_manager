package cn.wq.web;

import cn.wq.pojo.Order;
import cn.wq.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenchao
 * @Data 2023/3/29 12:48
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    @RequestMapping("/{id}")
    public Order getOrder(@PathVariable("id")Long id){
        Order order = orderService.gerOrderByid(id);
        return  order;

    }
}
