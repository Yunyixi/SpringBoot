package chapter.project.chapter07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Name FeiLong
 * @Date 2023/10/9
 * @注释 页面控制类
 */
@Controller
public class Chapter07Controller {

    // 影片详情页
    @GetMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type") String type, @PathVariable("path") String path) {
        return "detail/" + type + "/" + path;
    }

    // 自定义用户登录
    @GetMapping("/userLogin")
    public String toLoginPage() {
        return "login/login";
    }


}
