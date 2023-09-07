package chapter.project;

import chapter.project.chapter01.ChapterController;
import chapter.project.chapter02.properties.PetPerson;
import chapter.project.chapter03.batis.BatisCommentMapper;
import chapter.project.chapter03.jpa.JpaDiscussRepository;
import chapter.project.chapter03.redis.RedisPersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author IDEA
 * 测试类 用于测试
 * @Date 2023/9/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class chapterApplicationTest {
    String TAG = "ChapterApplicationTest";


    @Autowired
    private ChapterController chapterController; //注入ChapterController类

    //chapter02
    @Autowired
    private PetPerson petPerson;

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
        System.out.println("properties01单元测试返回的数据：" + petPerson);

    }


    //@Test //chapter01测试方法
    //public void Chapter03() {
    //查询MySQL数据信息操作
    //System.out.println(commentMapper.findById(1));
    //System.out.println(commentMapper.findById(4));
    //Comment comment = new Comment();

    //更新MySQL数据信息操作
    //comment.setId(7);
    //comment.setContent("真好，点个赞");
    //comment.setAuthor("小苏");
    //commentMapper.updateComment(comment);


    //插入MySQL数据信息操作
    //comment.setContent("很好，挺不错的");
    //comment.setAuthor("小发");
    //comment.setaId(3);
    //commentMapper.insertComment(comment);

    //删除MySQL数据信息操作
    //commentMapper.deleteComment(8);

    //jpa实现，实现数据操作
    //List<JpaDiscuss> jpalist = jpaDiscussRepository.findByAuthorNotNull();
    //System.out.println(jpalist);

        /*//redis实现，实现数据库操作
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
        System.out.println(save2);*/
    //}
}
