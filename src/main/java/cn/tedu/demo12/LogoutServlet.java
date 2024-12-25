package cn.tedu.demo12;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 删除 Cookie
        Cookie cookie = new Cookie("auth_token", "");
        cookie.setMaxAge(0); // 设置过期时间为 0
        cookie.setPath("/");
        resp.addCookie(cookie);

        // 重定向到登录页面
        resp.sendRedirect("/login_test.html");
    }
}
