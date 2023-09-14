package chapter.project.chapter04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;

/**
 * @Date 2023/9/7
 * @注释 获取并封装当前年份跳转到登录页login.html
 */
@Controller
public class LoginController {

   /* @GetMapping("/toLoginPage")

    public String toLoginPage(Model model) { //返回时间的格式
        // 获取当前的时间
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }

    public String saytoLoginPage() {
        return "Hello toLoginPage ";

    }*/
}
