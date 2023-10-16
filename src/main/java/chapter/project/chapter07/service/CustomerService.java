package chapter.project.chapter07.service;

import chapter.project.chapter07.beanconn.Authority;
import chapter.project.chapter07.beanconn.AuthorityRepository;
import chapter.project.chapter07.beanconn.Customer;
import chapter.project.chapter07.beanconn.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Name FeiLong
 * @Date 2023/9/6
 * @注释 定义查询用户及角色信息的服务窗口
 * 对用户数据结合 Redis 缓存进行处理，获取用户信息和用户权限信息
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    // 控制：使用唯一用户名查询用户信息
    public Customer getCustomer(String username) {
        Customer customer = null;
        Object o = redisTemplate.opsForValue().get("customer_" + username);
        if (o != null) {
            customer = (Customer) o;
        } else {
            customer = customerRepository.findByUsername(username);
            if (customer != null) {
                redisTemplate.opsForValue().set("customer_" + username, customer);
            }
        }
        return customer;
    }

    // 控制：使用唯一用户名查询用户权限
    public List<Authority> getCustomerAuthority(String username) {
        List<Authority> authorities = null;
        Object o = redisTemplate.opsForValue().get("authorities_" + username);
        if (o != null) {
            authorities = (List<Authority>) o;
        } else {
            authorities = authorityRepository.findAuthoritiesByUsername(username);
            if (authorities.size() > 0) {
                redisTemplate.opsForValue().set("authorities_" + username, authorities);
            }
        }
        return authorities;
    }
}

