package example.day06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 컨트롤러 사용처 웹 : JS(AJAX) , REACT(AXIOS) , 앱 , 소프트웨어
//역할 : AJAX [외부인] <-----연결다리[자바]---->서비스[자바] ---> repository--entity--> DB table

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;


    // 1. C
    @PostMapping("/do")
    public boolean bWrite( @RequestBody NoteDto noteDto){
        boolean result = noteService.bWrite(noteDto);
        return false;
    }

    // 2, R
    @GetMapping("/do")
    public List<NoteDto> bList(){
        List<NoteDto> result = noteService.bList();
        return result;
    }

    // 3. U
    @PutMapping("/do")
    public boolean bUpdate( @RequestBody NoteDto noteDto ){
        boolean result = noteService.bUpdate(noteDto);
        return false;
    }

    // 4. D
    @DeleteMapping("/do")
    public boolean bDelete(@RequestParam int no){
        boolean result = noteService.bDelete(no);
        return false;
    }
}
