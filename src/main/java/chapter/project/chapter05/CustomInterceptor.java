package chapter.project.chapter05;

import io.micrometer.core.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * @Name FeiLong
 * @Date 2023/9/12
 * 自定义一个拦截器类
 */
@Component
public class CustomInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 用户请求/admin开头的路径时，判断用户是否登录
        String uri = request.getRequestURI();
        System.out.println("+++ uri ===" + uri);
        // 用户信息
        Object loginUser = request.getSession().getAttribute("loginUser");
        //url 是不是以 /admin,/user 开头 并且loginUser为空
        if (uri.startsWith("/admin") || uri.startsWith("/login.html") && null == loginUser) {
            // 检查用户是否登录
            if (null == loginUser) {
                //地址拦截替换
                response.sendRedirect("/web");
                return false;
            }
        }

       /* // 特定路径用于登录拦截
        if (uri.startsWith("/admin")) {
            // 用户信息
            Object loginUser = request.getSession().getAttribute("loginUser");
            // 检查用户是否登录
            if (null == loginUser) {
                // 地址拦截替换
                response.sendRedirect("/web");
                return false;
            }
        }*/
        return true;
        //访问地址：http://localhost:8084/admin
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        //向request域中存放当前年份用于页面动态展示
        request.setAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse
            response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
