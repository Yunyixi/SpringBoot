package chapter.project.chapter07;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

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

    // 获取用户信息两种方式
    // 1.使用HttpSession获取用户信息
    /*@GetMapping("/getuserBySession")
    @ResponseBody
    public void getUser(HttpSession session) {
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            // 获取HttpSession中会话名称
            String element = names.nextElement();
            // 获取HttpSession应用上下文
            SecurityContextImpl attribute =
                    (SecurityContextImpl) session.getAttribute(element);
            System.out.println("element: " + element);
            System.out.println("attribute: " + attribute);
            // 获取用户相关信息
            Authentication authentication = attribute.getAuthentication();
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            System.out.println(principal);
            System.out.println("username: " + principal.getUsername());
        }
    }*/

    // 2.使用SecurityContextHolder获取用户信息
    @GetMapping("/getuserByContext")
    @ResponseBody
    public void getUser2() {
        // 获取应用上下文
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("userDetails: " + context);
        // 获取用户信息
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        System.out.println(principal);
        System.out.println("username: " + principal.getUsername());
    }
}
