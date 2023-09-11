package chapter.project.chapter05;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description
 * @Author IDEA
 * @Date 2023/9/11
 * 实现WebMvcConfigurer接口，扩展MVC功能
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {
    //添加视图功能
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 请求toLoginPage映射路径或者login.html页面都会自动映射到login.html页面
        registry.addViewController("/toLoginPage").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }

}
