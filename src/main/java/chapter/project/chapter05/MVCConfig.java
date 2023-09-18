package chapter.project.chapter05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Name FeiLong
 * @Date 2023/9/11
 * 实现WebMvcConfigurer接口，扩展MVC功能
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {
    @Autowired //引入自定义拦截器组件
    private CustomInterceptor customInterceptor;

    //添加视图功能
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 请求toLoginPage映射路径或者login.html页面都会自动映射到login.html页面
        registry.addViewController("/toLoginPage").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/web").setViewName("login");
        //registry.addViewController("/**").setViewName("login");
    }

    @Override //添加注册拦截器管理
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor)
                .addPathPatterns("/**") // 拦截所有的路径
                .excludePathPatterns("/login.html"); // 过滤放行/login.html的处理
    }

}
