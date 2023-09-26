package chapter.project.chapter06;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Name FeiLong
 * @Date 2023/9/25
 * @注释 CacheComment类操作的 Server 类
 */
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    // 根据id查询数据
    @Cacheable(cacheNames = "article") //对数据库操作方法进行缓存管理
    public CacheComment findById(int article_id) {
        Optional<CacheComment> optional = commentRepository.findById(article_id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    // 根据id更新数据
    @Cacheable(cacheNames = "article") //对数据库操作方法进行缓存管理
    public CacheComment updateComment(CacheComment cacheComment) {
        commentRepository.updateComment(cacheComment.getTitle(), cacheComment.getId());
        return cacheComment;
    }

    // 根据id删除数据
    @Cacheable(cacheNames = "article") //对数据库操作方法进行缓存管理
    public void deleteComment(int article_id) {
        commentRepository.deleteById(article_id);
    }

}
