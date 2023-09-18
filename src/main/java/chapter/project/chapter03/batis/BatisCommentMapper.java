package chapter.project.chapter03.batis;

import org.apache.ibatis.annotations.*;

/**
 * @Name FeiLong
 * @Date 2023/6/30 20:43
 * @注释
 */
@Mapper
public interface BatisCommentMapper {

    //查询数据操作
    @Select("SELECT * FROM t_comment WHERE id =#{id}")
    BatisComment findById(Integer id);

    //更新数据操作
    @Update("UPDATE t_comment SET content=#{content} WHERE id=#{id}")
    int updateComment(BatisComment batisComment);

    //@Update("UPDATE t_comment SET author=#{author} WHERE id=#{id}")
    //public int updateComment(BatisComment comment);


    //插入数据操作
    @Insert("INSERT INTO t_comment(content,author,a_id) " +
            "values (#{content},#{author},#{aId})")
    int insertComment(BatisComment batisComment);

    //删除数据操作
    @Delete("DELETE FROM t_comment WHERE id=#{id}")
    int deleteComment(Integer id);
}

