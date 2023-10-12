package example.day03.mapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/day03/delete")
public class DeleteMappingController {

    @DeleteMapping("/method1")
    public boolean method1 (@RequestParam String param1){
        System.out.println("param1 = " + param1);
        return true;
    }
    // 의미없는 주석
    @DeleteMapping("/method2")
    public boolean method2(@RequestParam Map< String , String > map){
        System.out.println("map = " + map);
        return false;
    }
}
