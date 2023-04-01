package cn.wq.web;

import cn.wq.pojo.Order;
import cn.wq.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public static void main(String[] args) {
      String url ="jdbc:mysql://localhost:3306/nacos";//?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
       String user ="root";
        String passsword="000000";

        try {
            Connection connection = DriverManager.getConnection(url, user, passsword);
            System.out.println("connection = " + connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
