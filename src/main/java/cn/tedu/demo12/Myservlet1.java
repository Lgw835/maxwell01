package cn.tedu.demo12;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/test")
public class Myservlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPut-----");

        System.out.println("name:"+req.getParameter("name1")+
                "age:"+req.getParameter("age1")+
                "love:"+req.getParameter("love1"));

        req.getRequestDispatcher("success.html").forward(req,resp);
    }


    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy-----");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init-----");
    }
}
