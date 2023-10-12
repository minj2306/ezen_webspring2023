package example.day03.restful;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/day03")
public class ServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param1 = req.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println("정상응답");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param1 = req.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println("정상응답");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param1 = req.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println("정상응답");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param1 = req.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println("정상응답");

    }

}
