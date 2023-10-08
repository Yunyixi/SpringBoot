package chapter.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

/**
 * @Name FeiLong
 * @Date 2023/9/6
 * @注释 项目入口启动类
 */
@Configuration // chapter02 定义该类是一个自定义配置类
@ImportResource("classpath:customization.xml") // chapter02 加载指定自定义配置文件位置和名称
@ServletComponentScan // chapter05 自动扫描并注册实现了 ServletComponent 接口的类
@EnableCaching //chapter06 开启Spring boot基于注解的缓存管理支持
//@Profile("test") //指定多环境类配置
@SpringBootApplication //用注解标识的类作为SpringBoot的入口类（启动类）
// public class ChapterApplication {
//程序主类继承SpringBootServletInitializer，并重写config()方法
public class ChapterApplication extends SpringBootServletInitializer {

    // 主程序的启动方法
    public static void main(String[] args) {
        SpringApplication.run(ChapterApplication.class, args);
        System.out.println("这是一个 Spring Boot 项目 发哥66，启动成功！！！");

    }

    //重写config()方法，5.4 war包需要
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ChapterApplication.class);
    }

}
