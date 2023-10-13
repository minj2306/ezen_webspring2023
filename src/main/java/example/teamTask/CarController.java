package example.teamTask;

import example.day06.NoteEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("")
    public List<CarDto> doGet(){
        List<CarDto> result = carService.doGet();

        return result;
    }
    @PostMapping("")
    public boolean doPost( @RequestBody CarDto carDto ){
        return carService.doPost( carDto );
    }

    @PutMapping("")
    public boolean doPut( @RequestBody CarDto carDto ){
        return carService.doPut( carDto );
    }

    @DeleteMapping("")
    public boolean doDelete( int cno ){
        return carService.doDelete( cno );
    }
}
