package chapter.project.chapter02.properties02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author IDEA
 * @Date 2023/9/11
 * 使用 @Value注入属性
 */
@Component //将类注入到Spring Boot容器中
public class ValuePerson {
    // @Value只支持属性的单个注入
    @Value("${properties.id}")
    private int id;
    @Value("${properties.name}")
    private String name;

    @Override
    public String toString() {
        return "ValuePerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
