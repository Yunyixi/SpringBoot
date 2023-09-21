package chapter.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @Name FeiLong
 * @Date 2023/9/6
 * @注释 入口启动类
 */
@SpringBootApplication //用注解标识的类作为SpringBoot的入口类（启动类）
//加载自定义xml配置文件配置
public class ChapterApplication {
    // 主程序的启动方法
    public static void main(String[] args) {
        SpringApplication.run(ChapterApplication.class, args);
        System.out.println("这是一个 Spring Boot 项目 发哥66，启动成功");
    }
}
