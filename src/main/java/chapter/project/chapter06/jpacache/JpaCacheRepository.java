package chapter.project.chapter06.jpacache;

import org.springframework.data.jpa.repository.*;

import javax.transaction.Transactional;

/**
 * @Name FeiLong
 * @Date 2023/9/25
 * @注释 修改信息的接口类
 */
public interface JpaCacheRepository extends JpaRepository<JpaCache, Integer> {
    // 根据id修改信息
    @Transactional
    @Modifying
    @Query("UPDATE t_article c SET c.title= ?1 WHERE  c.id = ?2")
    int updateCache(String title, Integer id);
}

