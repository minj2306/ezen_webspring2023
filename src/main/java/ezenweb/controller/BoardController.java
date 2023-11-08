package ezenweb.controller;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.PageDto;
import ezenweb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 1.
    @PostMapping("")
    public boolean write( BoardDto boardDto ){


        return boardService.write( boardDto );
    }

    // 2.
    @GetMapping("")
    public PageDto getAll(
            @RequestParam int page ,
            @RequestParam String key ,
            @RequestParam String keyword ,
            @RequestParam int view
    ){

        return boardService.getAll( page , key , keyword , view );
    }

    // 3.
    @PutMapping("")
    public boolean update( BoardDto boardDto ){

        return boardService.update( boardDto );
    }

    // 4.
    @DeleteMapping("")
    public boolean delete( @RequestParam int bno ){

        return boardService.delete( bno );
    }

    @GetMapping("/doGet")
    public BoardDto doGet( @RequestParam int bno ){

        return boardService.doGet( bno );
    }
}
