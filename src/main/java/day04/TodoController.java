package day04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 스프링 빈 : 스프링 컨테이너(저장소) 에 저장된 객체 [ 이유 : 스프링이 대신 객체 관리 => 여러 개발자들이 작업했을떄 기준 ]

//@Controller // Spring MVC 중 해당 클래스를 Controller 로 사용 // 스프링 컨테이너 빈 등록
@RestController // Controller + ResponseBody
@RequestMapping("/todo")// HTTP 로 부터의 해당 클래스의 매핑 주소 만들기
public class TodoController {

    @Autowired
    public TodoService todoService;

    //REST : HTTP 기반으로 GET , POST , PUT , DELETE 메소드 이용한 웹 서비스

    // 1.
    //@ResponseBody // 응답객체 자동 지원 [ 단 해당 클래스가 @RestController 사용했을떄 생략 가능
    @PostMapping("")
    public boolean doPost( @RequestBody TodoDto todoDto ) { // 요청 매개변수 : 입력받은 정보들 [Dto]
                            // @RequestBody : HTTP BODY( post , put ) json 형식으로 요청 매핑
        System.out.println("TodoController.doPost");
        System.out.println("todoDto = " + todoDto);

        return todoService.doPost(todoDto);

    }

    // 2.
    @GetMapping("")
    public List<TodoDto> doGet(){ // 요청 매개변수 : 출력에 필요한 정보들 [ x ]
        System.out.println("TodoController.doGet");
        return todoService.doGet();
    }

    // 3.
    @PutMapping("")
    public boolean doPut( @RequestBody  TodoDto todoDto ){ // 요청 매개변수 : 수정에 필요한 정보들 [ Dto ]
                            
        System.out.println("TodoController.doPut");
        System.out.println("todoDto = " + todoDto);
        return todoService.doPut(todoDto);
    }

    // 4.
    @DeleteMapping("")
    public boolean doDelete( @RequestParam int tno ){ // 요청 매개변수 : 삭제에 필요한 정보들 [int]
                                // @RequestParam : 쿼리스트링 에서의 매개변수 요청 매핑
        System.out.println("TodoController.doDelete");
        System.out.println("tno = " + tno);
        return todoService.doDelete(tno);
    }

    //5.HTML 반환하는 매핑주소 만들기
    @GetMapping("/index")
    public Resource getIndex(){
        return new ClassPathResource("templates/todo.html");
    }
    // Resource : 정적파일 반환 타입
    // Resource : org.springframework.core.io.Resource;
    // ClassPathResource : org.springframework.core.io.ClassPathResource;

}
