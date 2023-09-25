package chapter.project.chapter06;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Name FeiLong
 * @Date 2023/9/25
 * @注释
 */
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    // 根据id查询信息
    @Cacheable(cacheNames = "article")
    public CacheComment findById(int article_id) {
        Optional<CacheComment> optional = commentRepository.findById(article_id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    // 更新信息
    @Cacheable(cacheNames = "article")
    public CacheComment updateComment(CacheComment cacheComment) {
        commentRepository.updateComment(cacheComment.getTitle(), cacheComment.getId());
        return cacheComment;
    }

    // 删除信息
    @Cacheable(cacheNames = "article")
    public void deleteComment(int article_id) {
        commentRepository.deleteById(article_id);
    }

}
