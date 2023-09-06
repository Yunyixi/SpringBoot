package chapter.project.chapter03.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

/**
 * @Description
 * @Author IDEA
 * @Date 2023/9/5
 */
public interface JpaDiscussRepository extends JpaRepository<JpaDiscuss, Integer> {

    //查询author非空的Discuss评论集合
    List<JpaDiscuss> findByAuthorNotNull();

    //根据文章id分页查询Discuss评论集合
    @Query("SELECT c FROM t_comment c WHERE  c.aId = ?1")
    List<JpaDiscuss> getDiscussPaged(Integer aid, Pageable pageable);

    //使用元素SQL语句，根据文章id分页查询Discuss评论集合
    @Query(value = "SELECT * FROM t_comment  WHERE  a_Id = ?1", nativeQuery = true)
    List<JpaDiscuss> getDiscussPaged2(Integer aid, Pageable pageable);

    //根据评论id修改评论作者author
    @Transactional
    @Modifying
    @Query("UPDATE t_comment c SET c.author = ?1 WHERE  c.id = ?2")
    int updateDiscuss(String author, Integer id);

    //根据评论id删除评论
    @Transactional
    @Modifying
    @Query("DELETE t_comment c WHERE  c.id = ?1")
    int deleteDiscuss(Integer id);

}
