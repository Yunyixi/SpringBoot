package chapter.project;

import chapter.project.chapter01.ChapterController;
import chapter.project.chapter02.connecor.DBConnector;
import chapter.project.chapter02.properties.PetPerson;
import chapter.project.chapter02.properties02.ValuePerson;
import chapter.project.chapter02.properties03.PropertiesExample;
import chapter.project.chapter03.batis.BatisComment;
import chapter.project.chapter03.batis.BatisCommentMapper;
import chapter.project.chapter03.jpa.JpaDiscuss;
import chapter.project.chapter03.jpa.JpaDiscussRepository;
import chapter.project.chapter03.redis.RedisAddress;
import chapter.project.chapter03.redis.RedisFamily;
import chapter.project.chapter03.redis.RedisPerson;
import chapter.project.chapter03.redis.RedisPersonRepository;
import chapter.project.chapter04.LoginController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2023/9/6
 * @注释 测试类 用于测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class chapterApplicationTest {

    String TAG = "ChapterApplicationTest";
    //chapter01
    @Autowired
    private ChapterController chapterController; //注入ChapterController类

    //chapter02
    @Autowired
    private PetPerson petPerson;
    @Autowired
    private ValuePerson valuePerson;
    @Autowired
    private DBConnector dbConnector;
    @Autowired
    private PropertiesExample propertiesExample;

    //chapter03
    @Autowired
    private BatisCommentMapper batisCommentMapper;
    @Autowired
    private JpaDiscussRepository jpaDiscussRepository;
    @Autowired
    private RedisPersonRepository redisPersonRepository;

    //chapter04
    @Autowired
    private LoginController loginController;

    @Test //chapter01测试方法
    public void Chapter01() {

        System.out.println(TAG + "单元测试返回的数据：" + chapterController.sayHello());
    }

    @Test
    public void Chapter02() {
        System.out.println("properties01单元测试返回的数据：" + petPerson);
        System.out.println("properties01单元测试返回的数据：" + valuePerson);

        dbConnector.configure(); //chapter02 connecor当前运行的配置环境
    }


    @Test //chapter03测试方法
    public void Chapter03() {
        //查询MySQL数据信息操作
        System.out.println(batisCommentMapper.findById(1));
        System.out.println(batisCommentMapper.findById(4));
        BatisComment batisComment = new BatisComment();

        //更新MySQL数据信息操作
        batisComment.setId(7);
        batisComment.setContent("真好，点个赞");
        batisComment.setAuthor("小苏");
        batisCommentMapper.updateComment(batisComment);

        //插入MySQL数据信息操作
        batisComment.setContent("很好，挺不错的");
        batisComment.setAuthor("小发");
        batisComment.setaId(3);
        batisCommentMapper.insertComment(batisComment);

        //删除MySQL数据信息操作
        batisCommentMapper.deleteComment(8);

        //chapter02 jpa实现，实现数据操作
        List<JpaDiscuss> jpalist = jpaDiscussRepository.findByAuthorNotNull();
        System.out.println(jpalist);

        //chapter02 redis实现，实现数据库操作
        RedisPerson redisPerson = new RedisPerson("张", "有才");
        RedisPerson redisPerson2 = new RedisPerson("James", "Harden");
        // 创建并添加住址信息
        RedisAddress redisAddress = new RedisAddress("北京", "China");
        redisPerson.setRedisAddress(redisAddress);
        // 创建并添加家庭成员
        List<RedisFamily> redislist = new ArrayList<>();
        RedisFamily dad = new RedisFamily("父亲", "张良");
        RedisFamily mom = new RedisFamily("母亲", "李香君");
        redislist.add(dad);
        redislist.add(mom);
        redisPerson.setRedisFamilyList(redislist);
        // 向Redis数据库添加数据
        RedisPerson save = redisPersonRepository.save(redisPerson);
        RedisPerson save2 = redisPersonRepository.save(redisPerson2);
        System.out.println(save);
        System.out.println(save2);
    }

    /*
    @Test //chapter04测试方法
    public void Chapter04() {
        //在项目入口启动类运行
    }
    */
}
