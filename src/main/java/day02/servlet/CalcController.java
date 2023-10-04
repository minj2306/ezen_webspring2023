package day02.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc/makeResult")
public class CalcController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // soutv : 근접한 변수의 출력
        String num1 = req.getParameter("num1");
        System.out.println("num1 = " + num1);

        String num2 = req.getParameter("num2");
        System.out.println("num2 = " + num2);

    }
}
