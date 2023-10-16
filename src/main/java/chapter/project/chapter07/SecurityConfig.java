package chapter.project.chapter07;


import chapter.project.chapter07.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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

    @Autowired
    protected UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //  密码需要设置编码器
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
/*
        // 1、使用内存用户信息，作为测试使用
        auth.inMemoryAuthentication().passwordEncoder(encoder)
                .withUser("shitou").password(encoder.encode("123456")).roles("common")
                .and()
                .withUser("李四").password(encoder.encode("123456")).roles("vip");

        // 2、使用 JDBC 进行身份认证,数据库
        String userSQL = "select username,password,valid from t_customer " + "where username = ?";
        String authoritySQL = "select c.username,a.authority from t_customer c, " + "t_authority 	a,t_customer_authority ca where " + "ca.customer_id=c.id and ca.authority_id=a.id and 	c.username =?";
        auth.jdbcAuthentication().passwordEncoder(encoder)
                .dataSource(dataSource)
                .usersByUsernameQuery(userSQL)
                .authoritiesByUsernameQuery(authoritySQL);
        */
        //3、使用 UserDetailsService 进行身份认证
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

    @Override // 自定义用户访问控制
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                // 需要对 static 文件夹下静态资源进行统一放行
                .antMatchers("/login/**").permitAll()
                .antMatchers("/detail/common/**").hasRole("common")
                .antMatchers("/detail/vip/**").hasRole("vip")
                .anyRequest().authenticated();

        // 自定义用户登录控制
        http.formLogin()
                .loginPage("/userLogin").permitAll()
                .usernameParameter("name").passwordParameter("pwd")
                .defaultSuccessUrl("/")
                .failureUrl("/userLogin?error");

        // 自定义用户退出登录控制
        http.logout()
                .logoutUrl("/mylogout")
                .logoutSuccessUrl("/");

    }

}

