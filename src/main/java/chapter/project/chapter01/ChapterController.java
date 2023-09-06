package chapter.project.chapter01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author IDEA
 * @Date 2023/9/6
 */
@RestController //用于标记一个类是控制器类，并且该类的方法返回的结果直接作为响应体返回给客户端
public class ChapterController {

    //用于将HTTP请求映射到控制器的处理方法上，应该调用哪个方法进行处理。
    @RequestMapping(value = "/hello")

    public String sayHello() {
        return "Hello SpringBoot ";

    }
}
