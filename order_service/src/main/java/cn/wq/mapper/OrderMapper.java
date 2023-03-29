package cn.wq.mapper;

import cn.wq.pojo.Order;
import org.apache.ibatis.annotations.Select;

/**
 * @author chenchao
 * @Data 2023/3/29 11:59
 **/

public interface OrderMapper {
    @Select("select * from tb_order where id=#{id}")
    Order gerOrder(Long id);
}
