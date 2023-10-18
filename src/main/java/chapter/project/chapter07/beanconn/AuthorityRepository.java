package chapter.project.chapter07.beanconn;


import chapter.project.chapter07.beanconn.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Name FeiLong
 * @Date 2023/9/6
 * @注释 实体类接口实现对数据库的操作
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    @Query(value = "select a.* from t_customer c,t_authority a,t_customer_authority ca where ca.customer_id=c.id and ca.authority_id=a.id and c.username =?1", nativeQuery = true)
    List<Authority> findAuthoritiesByUsername(String username);

}
