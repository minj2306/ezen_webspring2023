package day04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// MVC 3티어 계층에서 사용되는 Service 계층 [비즈니스로직 : 기능관리 공간]
@Service // Spring MVC 중 해당 클래스를 Service로 사용 // 스프링 빈 사용
public class TodoService {

    @Autowired
    private TodoDao todoDao;
    // 1.
    public boolean doPost( TodoDto todoDto){
        System.out.println("TodoService.doPost");
        System.out.println("todoDto = " + todoDto);
        return todoDao.doPost(todoDto);
    }
    // 2.
    public List<TodoDto> doGet(){
        System.out.println("TodoService.doGet");
        return todoDao.doGet();
    }
    // 3.
    public boolean doPut( TodoDto todoDto ){
        System.out.println("TodoService.doPut");
        System.out.println("todoDto = " + todoDto);
        return todoDao.doPut(todoDto);
    }
    
    // 4.
    public boolean doDelete( int tno ){
        System.out.println("TodoService.doDelete");
        System.out.println("tno = " + tno);
        return todoDao.doDelete(tno);
    }
    
}
