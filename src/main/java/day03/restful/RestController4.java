package day03.restful;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController // 해당 클래스를 스프링 MVC 중 컨트롤러 객체로 사용 // 스프링 컨트롤러 객체를 빈에 등록

public class RestController4 {

    // @ResponseBody : 해당 클래스가 @RestController 인 경우에는 생략가능
   @GetMapping("/day03/blue")
    // 1. GET
    public String getBlue(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }

    @PostMapping("/day03/blue")
    // 2. POST
    public String postBlue(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }

    @PutMapping("/day03/blue")
    // 3. PUT
    public String putBlue(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }

    @DeleteMapping("/day03/blue")
    // 4. DELETE
    public String deleteBlue(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }
}
