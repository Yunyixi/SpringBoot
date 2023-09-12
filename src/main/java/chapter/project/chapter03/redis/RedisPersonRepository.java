package chapter.project.chapter03.redis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Date 2023/9/6
 * @注释
 */
public interface RedisPersonRepository extends CrudRepository<RedisPerson, String> {

    List<RedisPerson> findByLastname(String lastname);

    Page<RedisPerson> findPersonByLastname(String lastname, Pageable page);

    List<RedisPerson> findByFirstnameAndLastname(String firstname, String lastname);

    List<RedisPerson> findByAddress_City(String city);

    List<RedisPerson> findByFamilyList_Username(String username);
}
