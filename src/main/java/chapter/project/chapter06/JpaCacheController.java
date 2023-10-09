package chapter.project.chapter06;

import chapter.project.chapter06.jpacache.CacheService;
import chapter.project.chapter06.jpacache.JpaCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Name FeiLong
 * @Date 2023/9/25
 * @注释 浏览器访问页面控制类
 */
@RestController
public class JpaCacheController {
    @Autowired
    private CacheService cacheService;

    // 查询
    @GetMapping("/get/{id}") //http://localhost:8084/get/2
    public JpaCache findById(@PathVariable("id") int article_id) {
        JpaCache jpaCache = cacheService.findById(article_id);
        return jpaCache;
    }

    // 更新
    @GetMapping("/update/{id}/{title}") //http://localhost:8084/update/1/update
    public JpaCache updateCache(@PathVariable("id") int article_id,
                                @PathVariable("title") String title) {
        JpaCache jpaCache = cacheService.findById(article_id);
        jpaCache.setTitle(title);
        JpaCache updateComment = cacheService.updateCache(jpaCache);
        return updateComment;
    }

    // 删除
    @GetMapping("/delete/{id}") //http://localhost:8084/delete/3
    public void deleteComment(@PathVariable("id") int article_id) {

        cacheService.deleteCache(article_id);
    }

}
