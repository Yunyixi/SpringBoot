package chapter.project;

import chapter.project.chapter03.redis.RedisAddress;
import chapter.project.chapter03.redis.RedisFamily;
import chapter.project.chapter03.redis.RedisPerson;
import chapter.project.chapter03.redis.RedisPersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Name FeiLong
 * @Date 2023/9/6
 * @注释 chapter03 Redis 测试类 用于测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
    @Autowired
    private RedisPersonRepository redisPersonRepository;

    @Test
    public void savePerson() {
        RedisPerson redisPerson = new RedisPerson("张", "有才");
        RedisPerson redisPerson2 = new RedisPerson("James", "Harden");
        // 创建并添加住址信息
        RedisAddress address = new RedisAddress("北京", "China");
        redisPerson.setRedisAddress(address);
        // 创建并添加家庭成员
        List<RedisFamily> list = new ArrayList<>();
        RedisFamily dad = new RedisFamily("父亲", "张良");
        RedisFamily mom = new RedisFamily("母亲", "李香君");
        list.add(dad);
        list.add(mom);
        redisPerson.setRedisFamilyList(list);
        // 向Redis数据库添加数据
        RedisPerson save = redisPersonRepository.save(redisPerson);
        RedisPerson save2 = redisPersonRepository.save(redisPerson2);
        System.out.println(save);
        System.out.println(save2);
    }

    @Test
    public void selectPerson() {
        List<RedisPerson> redisPersonList = redisPersonRepository.findByAddress_City("北京");
        System.out.println(redisPersonList);
    }

    @Test
    public void updatePerson() {
        RedisPerson redisPerson = redisPersonRepository.findByFirstnameAndLastname("张", "有才").get(0);
        redisPerson.setLastname("小明");
        RedisPerson update = redisPersonRepository.save(redisPerson);
        System.out.println(update);
    }

    @Test
    public void deletePerson() {
        RedisPerson redisPerson = redisPersonRepository.findByFirstnameAndLastname("张", "小明").get(0);
        redisPersonRepository.delete(redisPerson);
    }

}
