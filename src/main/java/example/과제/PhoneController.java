package example.과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

     @PostMapping("")
    public boolean doPost(@RequestBody PhoneDto phoneDto){

         boolean result = phoneService.doPost(phoneDto);
         return result;
     }

     @GetMapping("")
    public List<PhoneDto> doGet(){

         List<PhoneDto> result = phoneService.doGet();
         return result;
     }

    @PutMapping("")
    public boolean doput(@RequestBody PhoneDto phoneDto){

         boolean result = phoneService.doPut(phoneDto);
         return result;
    }

    @DeleteMapping("")
    public boolean doDelete(@RequestParam int pno){

         boolean result = phoneService.doDelete(pno);
         return result;
    }

    @GetMapping("/index")
    public Resource getIndex(){
         return new ClassPathResource("templates/phoneBook.html");
    }
}
