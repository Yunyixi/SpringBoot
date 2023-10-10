package chapter.project;

import chapter.project.chapter01.ChapterController;
import chapter.project.chapter02.connecor.DBConnector;
import chapter.project.chapter02.properties.PetPerson;
import chapter.project.chapter02.properties02.ValuePerson;
import chapter.project.chapter02.properties03.PropertiesExample;
import chapter.project.chapter03.batis.BatisComment;
import chapter.project.chapter03.batis.BatisCommentMapper;
import chapter.project.chapter03.jpa.JpaDiscussRepository;
import chapter.project.chapter03.redis.RedisPersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Name FeiLong
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
    @Autowired //全局配置文件数据校验
    private PropertiesExample propertiesExample;
    @Autowired
    private ApplicationContext applicationContext;

    //chapter03
    @Autowired
    private BatisCommentMapper batisCommentMapper;
    @Autowired
    private JpaDiscussRepository jpaDiscussRepository;
    @Autowired
    private RedisPersonRepository redisPersonRepository;

    @Test //chapter01测试方法
    public void Chapter01() {

        System.out.println(TAG + "单元测试返回的数据：" + chapterController.sayHello());
    }

    @Test
    public void Chapter02() {
        System.out.println("properties02单元测试返回的数据：" + petPerson);
        System.out.println("properties02单元测试返回的数据：" + valuePerson);

        dbConnector.configure(); //chapter02 connecor当前运行的配置环境

        System.out.println("自定义xml配置文件是否注入：" + applicationContext.containsBean("XmlService"));
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
    }
}
