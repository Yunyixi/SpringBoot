package chapter.project.chapter07;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

/**
 * @Name FeiLong
 * @Date 2023/10/9
 * @注释 自定义身份认证 WebSecurityConfigurerAdapter 类
 */
@EnableWebSecurity //开启MVC Security安全支持
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    protected DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //  密码需要设置编码器
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 1、使用内存用户信息，作为测试使用
        auth.inMemoryAuthentication().passwordEncoder(encoder)
                .withUser("shitou").password(encoder.encode("123456")).roles("common")
                .and()
                .withUser("李四").password(encoder.encode("123456")).roles("vip");
    }

}

