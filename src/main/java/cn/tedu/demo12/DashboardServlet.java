package cn.tedu.demo12;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

import java.io.IOException;

@WebServlet(value = "/dashbord")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies= req.getCookies();
        boolean isAuthenticated=false;

        if(cookies!=null){
            for(Cookie cookie:cookies){
                if ("auth_token".equals(cookie.getName()) && "userToken123".equals(cookie.getValue())) {
                    isAuthenticated = true;
                    break;
                }
            }
        }

        if (isAuthenticated) {
            resp.setContentType("text/html");
            resp.getWriter().write(
                    "<!DOCTYPE html><html><head><title>Dashboard</title></head><body>" +
                            "<h1>Dashboard</h1><p>Welcome back, user!</p>" +
                            "<form action='/logout' method='get'><button type='submit'>Logout</button></form>" +
                            "</body></html>"
            );
        } else {
            resp.sendRedirect("/login_test.html");
        }

    }
}
