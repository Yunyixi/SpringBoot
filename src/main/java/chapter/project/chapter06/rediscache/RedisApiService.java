package chapter.project.chapter06.rediscache;

import chapter.project.chapter03.jpa.JpaDiscuss;
import chapter.project.chapter03.jpa.JpaDiscussRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Name FeiLong
 * @Date 2023/10/8
 * @注释 基于 Api 的Redis缓存实现
 */
@Service
public class RedisApiService {
    @Autowired
    private JpaDiscussRepository jpaDiscussRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    public JpaDiscuss findById(int comment_id) {
        // 先从Redis缓存中查询数据
        Object object = redisTemplate.opsForValue().get("comment_" + comment_id);
        if (object != null) {
            return (JpaDiscuss) object;
        } else {
            // 缓存中没有，就进入数据库查询
            Optional<JpaDiscuss> optional = jpaDiscussRepository.findById(comment_id);
            if (optional.isPresent()) {
                JpaDiscuss comment = optional.get();
                // 将查询结果进行缓存，并设置有效期为1天
                redisTemplate.opsForValue().set("comment_" + comment_id, comment, 1, TimeUnit.DAYS);

                // redisTemplate.opsForValue().set("comment_" + comment_id, comment);
                // redisTemplate.expire("comment_" + comment_id, 90, TimeUnit.SECONDS);

                return comment;
            } else {
                return null;
            }
        }
    }

    public JpaDiscuss updateComment(JpaDiscuss comment) {
        jpaDiscussRepository.updateDiscuss(comment.getAuthor(), comment.getaId());
        // 更新数据后进行缓存更新
        redisTemplate.opsForValue().set("comment_" + comment.getId(), comment);
        return comment;
    }

    public void deleteComment(int comment_id) {
        jpaDiscussRepository.deleteById(comment_id);
        // 删除数据后进行缓存删除
        redisTemplate.delete("comment_" + comment_id);
    }

}

