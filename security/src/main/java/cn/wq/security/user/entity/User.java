package cn.wq.security.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 
 * </p>
 *
 * @author autoGen
 * @since 2023-03-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@Component
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;
    @TableField(value="password")
    private  String password;

    @TableField("phone")
    private String phone;

    @TableField("createtime")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createtime;

    @TableField("email")
    private String email;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
