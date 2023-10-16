package chapter.project;


import chapter.project.chapter03.jpa.JpaDiscuss;
import chapter.project.chapter03.jpa.JpaDiscussRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

/**
 * @Name FeiLong
 * @Date 2023/9/6
 * @注释 chapter03 Jpa 测试类 用于测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTests {
    @Autowired
    private JpaDiscussRepository jpaDiscussRepository;

    // 1、使用JpaRepository内部方法进行数据操作
    @Test
    public void selectComment() {
        Optional<JpaDiscuss> optional = jpaDiscussRepository.findById(1);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        System.out.println();
    }

    // 2、使用方法名关键字进行数据操作
    @Test
    public void selectCommentByKeys() {
        List<JpaDiscuss> list = jpaDiscussRepository.findByAuthorNotNull();
        System.out.println(list);
    }

    // 3、使用@Query注解进行数据操作
    /*@Test
    public void selectCommentPaged() {
        Pageable pageable = PageRequest.of(0, 3);
        List<JpaDiscuss> allPaged = jpaDiscussRepository.getDiscussPaged(1, pageable);
        System.out.println(allPaged);
    }*/

    //  4、使用Example封装参数进行数据查询操作
    @Test
    public void selectCommentByExample() {
        JpaDiscuss jpadiscuss = new JpaDiscuss();
        jpadiscuss.setAuthor("张三");
        Example<JpaDiscuss> example = Example.of(jpadiscuss);
        List<JpaDiscuss> list = jpaDiscussRepository.findAll(example);
        System.out.println(list);
    }

    @Test
    public void selectCommentByExampleMatcher() {
        JpaDiscuss jpadiscuss = new JpaDiscuss();
        jpadiscuss.setAuthor("张");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("author", startsWith());
        Example<JpaDiscuss> example = Example.of(jpadiscuss, matcher);
        List<JpaDiscuss> list = jpaDiscussRepository.findAll(example);
        System.out.println(list);

    }

    //删除
    @Test
    public void deleteDiscuss() {
        jpaDiscussRepository.deleteDiscuss(7);
        System.out.println("已删除");
    }
}
