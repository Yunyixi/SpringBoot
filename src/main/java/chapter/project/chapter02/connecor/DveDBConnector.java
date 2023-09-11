package chapter.project.chapter02.connecor;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Description
 * @Author IDEA
 * @Date 2023/9/11
 */
@Configuration
@Profile("dev")
public class DveDBConnector implements DBConnector {
    @Override
    public void configure() {
        System.out.println("数据库配置环境Dev");
    }
}
