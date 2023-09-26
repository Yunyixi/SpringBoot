package chapter.project.chapter06;


import chapter.project.chapter06.jpacache.JpaCache;
import chapter.project.chapter06.jpacache.JpaCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Name FeiLong
 * @Date 2023/9/25
 * @注释 jpa redis 缓存服务类
 */
@Service
public class CacheService {
    @Autowired
    private JpaCacheRepository jpaCacheRepository;

    // 根据id查询数据
    @Cacheable(cacheNames = "article") //对数据库操作方法进行默认缓存管理
    public JpaCache findById(int article_id) {
        Optional<JpaCache> optional = jpaCacheRepository.findById(article_id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    // 根据id更新数据
    @Cacheable(cacheNames = "article") //对数据库操作方法进行默认缓存管理
    public JpaCache updateComment(JpaCache jpaCache) {
        jpaCacheRepository.updateComment(jpaCache.getTitle(), jpaCache.getId());
        return jpaCache;
    }

    // 根据id删除数据
    @Cacheable(cacheNames = "article") //对数据库操作方法进行默认缓存管理
    public void deleteComment(int article_id) {
        jpaCacheRepository.deleteById(article_id);
    }

}
