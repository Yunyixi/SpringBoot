package chapter.project.chapter02.properties03;

import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

/**
 * @Name FeiLong
 * @Date 2023/9/11
 * @注释
 */
@Component //将类注入到Spring Boot容器中
@ConfigurationProperties(prefix = "user")
@Validated
public class PropertiesExample {
    @Email //对属性进行规则匹配
    private String email;

    @URL
    private String url;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
