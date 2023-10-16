package chapter.project.chapter07.beanconn;

import chapter.project.chapter07.beanconn.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @Name FeiLong
 * @Date 2023/9/6
 * @注释
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String username);

    Customer findByPassword(String userpassword);

    // 根据id修改信息
    @Transactional
    @Modifying
    @Query("UPDATE t_customer c SET c.username= ?1 WHERE  c.id = ?2")
    int updateCache(String username, Integer id);

}
