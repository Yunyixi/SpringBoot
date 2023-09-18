package chapter.project.chapter05.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Name FeiLong
 * @Date 2023/9/14
 * @注释
 */
@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean getServlet(MyServlet myServlet) {
        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(myServlet, "/myServlet");
        return registrationBean;
        //访问的地址：http://localhost:8084/myServlet
    }

    @Bean
    public FilterRegistrationBean getFilter(MyFilter filter) {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
        registrationBean.setUrlPatterns(Arrays.asList("/toLoginPage", "/myFilter"));
        return registrationBean;
        //访问的地址：http://localhost:8084/myFilter 控制台会出现 "hello MyFilter"
    }
}
