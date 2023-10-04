package day03.restful;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller // 해당 클래스를 스프링 MVC 중 컨트롤러 객체로 사용 // 스프링 컨트롤러 객체를 빈에 등록
public class RestController1 {
    @RequestMapping(value = "/day03/black" , method = RequestMethod.GET)
    // 1. GET
    public void getBlack(HttpServletRequest request , HttpServletResponse response) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println("정상응답");

    }

    @RequestMapping(value = "/day03/black" , method = RequestMethod.POST)
    // 2. POST
    public void postBlack(HttpServletRequest request , HttpServletResponse response) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println("정상응답");

    }

    @RequestMapping(value = "/day03/black" , method = RequestMethod.PUT)
    // 3. PUT
    public void putBlack(HttpServletRequest request , HttpServletResponse response) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println("정상응답");

    }

    @RequestMapping(value = "/day03/black" , method = RequestMethod.DELETE)
    // 4. DELETE
    public void deleteBlack(HttpServletRequest request , HttpServletResponse response) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println("정상응답");

    }
}
