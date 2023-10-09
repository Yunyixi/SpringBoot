package chapter.project.chapter06;

import chapter.project.chapter03.jpa.JpaDiscuss;
import chapter.project.chapter06.rediscache.RedisApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Name FeiLong
 * @Date 2023/10/8
 * @注释 chapter03 JpaDiscuss类存放表对象数据
 */
@RestController
@RequestMapping("/api") // 窄化请求路径
public class RedisApiController {
    @Autowired
    private RedisApiService redisApiService;

    //查询
    @GetMapping("/get/{id}") //http://localhost:8084/api/get/2
    public JpaDiscuss findById(@PathVariable("id") int comment_id) {
        JpaDiscuss comment = redisApiService.findById(comment_id);
        return comment;
    }

    //更新
    @GetMapping("/update/{id}/{author}")
    public JpaDiscuss updateComment(@PathVariable("id") int comment_id,
                                    @PathVariable("author") String author) {
        JpaDiscuss comment = redisApiService.findById(comment_id);
        comment.setAuthor(author);
        JpaDiscuss updateComment = redisApiService.updateComment(comment);
        return updateComment;
    }

    //删除
    @GetMapping("/delete/{id}") //http://localhost:8084/api/delete/6
    public void deleteComment(@PathVariable("id") int comment_id) {
        redisApiService.deleteComment(comment_id);
    }

}
