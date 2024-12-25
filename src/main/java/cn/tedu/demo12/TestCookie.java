package cn.tedu.demo12;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.mail.Session;
import java.io.IOException;

@WebServlet(value="/cookies")
public class TestCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPut(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost-----------");

        HttpSession session=req.getSession();
        session.setAttribute("username","session-xiaohong");
        Cookie cookie = new Cookie("uname","cookie-xiaohong");
        cookie.setMaxAge(30);
        resp.addCookie(cookie);
        resp.getWriter().println("some content");
        resp.sendRedirect("showtest.jsp"); // 这样会报错



    }
}
