package example.day03.restful;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller // 해당 클래스를 스프링 MVC 중 컨트롤러 객체로 사용 // 스프링 컨트롤러 객체를 빈에 등록
@ResponseBody
public class RestController2 {
    @RequestMapping(value = "/day03/orange" , method = RequestMethod.GET)
    // 1. GET
    public String getBlack(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }

    @RequestMapping(value = "/day03/orange" , method = RequestMethod.POST)
    // 2. POST
    public String postBlack(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }

    @RequestMapping(value = "/day03/orange" , method = RequestMethod.PUT)
    // 3. PUT
    public String putBlack(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }

    @RequestMapping(value = "/day03/orange" , method = RequestMethod.DELETE)
    // 4. DELETE
    public String deleteBlack(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }
}
