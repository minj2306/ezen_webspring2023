package example.day03.restful;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController // 해당 클래스를 스프링 MVC 중 컨트롤러 객체로 사용 // 스프링 컨트롤러 객체를 빈에 등록

public class RestController3 {

    // @ResponseBody : 해당 클래스가 @RestController 인 경우에는 생략가능
    @RequestMapping(value = "/day03/red" , method = RequestMethod.GET)
    // 1. GET
    public String getRed(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }

    @RequestMapping(value = "/day03/red" , method = RequestMethod.POST)
    // 2. POST
    public String postRed(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }

    @RequestMapping(value = "/day03/red" , method = RequestMethod.PUT)
    // 3. PUT
    public String putRed(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }

    @RequestMapping(value = "/day03/red" , method = RequestMethod.DELETE)
    // 4. DELETE
    public String deleteRed(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }
}
