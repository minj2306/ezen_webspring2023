package day03.restful;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController // 해당 클래스를 스프링 MVC 중 컨트롤러 객체로 사용 // 스프링 컨트롤러 객체를 빈에 등록
@RequestMapping( value = "/day03") // 클래스에 매핑 URL 정의할 경우 해당 클래스 안에 메소드들의 공통 URL
public class RestController5 {

    // @ResponseBody : 해당 클래스가 @RestController 인 경우에는 생략가능
   @GetMapping("/pink")
    // 1. GET
    public String getPink(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }

    @PostMapping("/pink")
    // 2. POST
    public String postPink(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }

    @PutMapping("/pink")
    // 3. PUT
    public String putPink(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }

    @DeleteMapping("/pink")
    // 4. DELETE
    public String deletePink(HttpServletRequest request ) throws IOException{

        String param1 = request.getParameter( "param1" );
        System.out.println("param1 = " + param1);
        return "정상응답";

    }
}
