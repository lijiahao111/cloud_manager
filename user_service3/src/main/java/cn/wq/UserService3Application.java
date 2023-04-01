package cn.wq;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.wq.mapper")
@SpringBootApplication
public class UserService3Application {

    public static void main(String[] args) {
        SpringApplication.run(UserService3Application.class, args);
    }

}
