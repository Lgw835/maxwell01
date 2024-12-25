package cn.tedu.demo12;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/logintest")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet-----");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        // 验证用户名和密码（实际中应查询数据库）
        if ("admin".equals(username) && "1234".equals(password)) {
            // 生成 Token 或 Session ID
            String token = "userToken123";

            Cookie cookie=new Cookie("auth_token",token);
            cookie.setMaxAge(7*24*60*60);
            cookie.setPath("/");
            resp.addCookie(cookie);
            resp.sendRedirect("/dashbord");
        }else{
            resp.sendRedirect("/login_test.html?error=true");
        }

    }
}
