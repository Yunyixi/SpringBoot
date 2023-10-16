package chapter.project.chapter07.csrf;

import chapter.project.chapter07.beanconn.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name FeiLong
 * @Date 2023/10/14
 * @注释
 */
@Controller
public class CSRFController {

    @Autowired
    private CustomerRepository customerRepository;

    // 向用户修改页跳转
    @GetMapping("/toUpdate") //http://localhost:8084/toUpdate
    public String toUpdate() {
        return "csrf/csrfTest";
    }

    // 用户修改提交处理
    @ResponseBody
    @PostMapping(value = "/updateUser")
    public String updateUser(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        System.out.println(username);
        System.out.println(password);
        String csrf_token = request.getParameter("_csrf");
        System.out.println(csrf_token);
        customerRepository.updateCache(username, 3);
        return "OK，已完成更新";
    }

}

