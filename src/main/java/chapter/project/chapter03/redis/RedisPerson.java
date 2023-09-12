package chapter.project.chapter03.redis;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;
import java.util.List;

/**
 * @Date 2023/9/5
 * @注释
 */
@RedisHash("persons")
public class RedisPerson {
    @Id
    private String id;
    @Indexed
    private String firstname;
    @Indexed
    private String lastname;
    private RedisAddress redisAddress;
    private List<RedisFamily> redisFamilyList;

    public RedisPerson(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public RedisPerson() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public RedisAddress getRedisAddress() {
        return redisAddress;
    }

    public void setRedisAddress(RedisAddress redisAddress) {
        this.redisAddress = redisAddress;
    }

    public List<RedisFamily> getRedisFamilyList() {
        return redisFamilyList;
    }

    public void setRedisFamilyList(List<RedisFamily> redisFamilyList) {
        this.redisFamilyList = redisFamilyList;
    }

    @Override
    public String toString() {
        return "RedisPerson{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", redisAddress=" + redisAddress +
                ", redisFamilyList=" + redisFamilyList +
                '}';
    }
}

