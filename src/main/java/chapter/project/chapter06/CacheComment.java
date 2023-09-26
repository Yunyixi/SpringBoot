package chapter.project.chapter06;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Name FeiLong
 * @Date 2023/9/25
 * @注释 Spring Boot默认缓存管理
 */
@Entity(name = "t_article") //实体类映射的数据库的表名
public class CacheComment implements Serializable { //实现序列化接口，不然可能 缓存 报错
    @javax.persistence.Id //标记实体类中的主键字段
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置主键自增策略
    private Integer id;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CacheComment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
