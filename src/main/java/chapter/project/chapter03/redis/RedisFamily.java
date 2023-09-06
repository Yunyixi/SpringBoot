package chapter.project.chapter03.redis;

import org.springframework.data.redis.core.index.Indexed;

/**
 * @Description
 * @Author IDEA
 * @Date 2023/9/5
 */
public class RedisFamily {
    @Indexed
    private String type;
    @Indexed
    private String username;

    public RedisFamily(String type, String username) {
        this.type = type;
        this.username = username;
    }

    public RedisFamily() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "RedisFamily{" +
                "type='" + type + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

