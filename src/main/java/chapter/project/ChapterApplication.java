package chapter.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * @Name FeiLong
 * @Date 2023/9/6
 * @注释 入口启动类
 */
@ServletComponentScan //自动扫描并注册实现了 ServletComponent 接口的类
@SpringBootApplication //用注解标识的类作为SpringBoot的入口类（启动类）
// @ImportResource("classpath:application.xml") //加载自定义xml配置文件配置
// public class ChapterApplication {

//程序主类继承SpringBootServletInitializer，并重写config()方法
public class ChapterApplication extends SpringBootServletInitializer {

    // 主程序的启动方法
    public static void main(String[] args) {
        SpringApplication.run(ChapterApplication.class, args);
        System.out.println("这是一个 Spring Boot 项目 发哥66，启动成功！！！");
        System.out.println("寒心 真正的心寒起于2023年9月23号！！！");
        System.out.println("真正的心寒不是大吵大闹,我的话你无动于衷,真正的失望不是泪流满面,沉默是最狠的报复,你的事我不再过问");

    }

    //重写config()方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ChapterApplication.class);
    }

}
