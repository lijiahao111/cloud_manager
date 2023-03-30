package cn.wq.security.config;

import cn.wq.security.detail.PersonDetail;
import cn.wq.security.user.entity.User;
import cn.wq.security.user.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.file.OpenOption;
import java.util.Collection;

/**
 * @author chenchao
 * @Data 2023/3/27 18:12
 **/
@Component
@RequiredArgsConstructor
public class SecurityUserDetailService  implements UserDetailsService {

    private final IUserService userService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User>  userWrapper=new QueryWrapper<>();
        userWrapper.eq("name",username);
        User user =null;
        user=userService.getOne(userWrapper);
      //  passwordEncoder.encode(user.getPassword());
        if (user==null) {
            throw new UsernameNotFoundException("无该用户"+username);
        }

      return new PersonDetail(user);
    }

    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("123456");
        boolean matches = new BCryptPasswordEncoder().matches("123456", "$2a$10$QIMkjQsLP94QdXeQxmLzWeoZLouTT2MYe1SAEBJL4cj/M.7DmSU/G");

        System.out.println("encode = " + matches);
    }
}
