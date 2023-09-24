package chapter.project.chapter02.connecor;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Name FeiLong
 * @Date 2022/12/11
 * @注释 Test环境端口8084
 */
@Configuration
@Profile("test")
public class TestDBConnector implements DBConnector {
    @Override
    public void configure() {
        System.out.println("数据库实现方法Test 8084");
    }
}
