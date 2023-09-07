package chapter.project.chapter04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;

/**
 * @Description
 * @Author IDEA
 * @Date 2023/9/7
 * 获取并封装当前年份跳转到登录页login.html
 */
@Controller
public class LoginController {
    
    @GetMapping("/toLoginPage")

    public String toLoginPage(Model model) {
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }
}
