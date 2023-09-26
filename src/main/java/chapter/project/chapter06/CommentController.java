package chapter.project.chapter06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Name FeiLong
 * @Date 2023/9/25
 * @注释 浏览器访问页面控制类
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 查询
    @GetMapping("/get/{id}") //http://localhost:8084/get/1
    public CacheComment findById(@PathVariable("id") int article_id) {
        CacheComment cacheComment = commentService.findById(article_id);
        return cacheComment;
    }

    // 更新
    @GetMapping("/update/{id}/{title}") //http://localhost:8084/update/1/update
    public CacheComment updateComment(@PathVariable("id") int article_id,
                                      @PathVariable("title") String title) {
        CacheComment cacheComment = commentService.findById(article_id);
        cacheComment.setTitle(title);
        CacheComment updateComment = commentService.updateComment(cacheComment);
        return updateComment;
    }

    // 删除
    @GetMapping("/delete/{id}") //http://localhost:8084/delete/3
    public void deleteComment(@PathVariable("id") int article_id) {

        commentService.deleteComment(article_id);
    }

}
