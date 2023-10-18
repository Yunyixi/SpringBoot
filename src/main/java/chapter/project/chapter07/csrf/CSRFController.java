package chapter.project.chapter07.csrf;

import chapter.project.chapter07.beanconn.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name FeiLong
 * @Date 2023/10/14
 * @注释 CSRF防护功能关闭，用户信息控制类
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
        // 获取应用上下文
        SecurityContext context = SecurityContextHolder.getContext();
        // 获取登录的用户信息
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        System.out.println(principal.getUsername());
        // 获取登录的用户id
        Integer updateId = customerRepository.findIdByUsername(principal.getUsername());
        System.out.println(updateId);
        // 更新用户表中对应id的用户名
        Integer result = customerRepository.updateById(username, updateId);
        if (result == null) {
            // 处理异常，例如返回错误信息
            return "Error: 更新失败";
        }
        return "OK，已完成更新";
    }
}

