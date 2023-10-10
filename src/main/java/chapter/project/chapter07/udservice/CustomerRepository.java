package chapter.project.chapter07.udservice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Name FeiLong
 * @Date 2023/9/6
 * @注释
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String username);

    Customer findByPassword(String userpassword);
}
