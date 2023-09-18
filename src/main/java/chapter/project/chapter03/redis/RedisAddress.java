package chapter.project.chapter03.redis;

import org.springframework.data.redis.core.index.Indexed;

/**
 * @Name FeiLong
 * @Date 2023/9/5
 * @注释
 */
public class RedisAddress {
    @Indexed
    private String city;
    @Indexed
    private String country;

    public RedisAddress(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public RedisAddress() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "RedisAddress{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
