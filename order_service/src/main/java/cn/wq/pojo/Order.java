package cn.wq.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chenchao
 * @Data 2023/3/29 11:57
 **/
@Data
public class Order {

    private Long id;
    private String name;
    private BigDecimal price;
    private Integer num;
    private Long user_id;
    private User user;
}
