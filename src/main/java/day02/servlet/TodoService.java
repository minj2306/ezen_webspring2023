package day02.servlet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TodoService {
    
    // 1. 등록 서비스
    public void register( TodoDto todoDto ){
        System.out.println("TodoService.register");
    }

    // 2. 출력서비스
    public List<TodoDto> getList(){
    
        // 2. 스트림 문법을 사용했을떄
        List<TodoDto> todoDtos = IntStream.range( 0 , 10 ).mapToObj( i -> {
            TodoDto todoDto = TodoDto.builder()
                    .tno((long)i)
                    .title("Todo.."+i)
                    .dueDate(LocalDate.now())
                    .build();
            return todoDto;
        }).collect(Collectors.toList());
        return todoDtos;
    } 
    
     
}

//IntStream.range( 시작함수 , 끝 함수 ) 
// .mapToObj() : return 값을 반환해서 배열/리스트에 대입
// .mapToObj().collect(Collectors.toList()) : 해당 커렉션 타입으로 반환해서 객체 대입
//1. 스트림 문법을 사용하지 않을떄
        /*List<TodoDto> list = new ArrayList<>();

        for( int i = 0 ; i<10 ;i++ ){
            // 생성자가 아닌 빌더패턴을 이용한 객체 생성
            TodoDto todoDto = TodoDto.builder()
                    .tno((long)i)
                    .title("Todo.."+i)
                    .dueDate(LocalDate.now())
                    .build();
            list.add(todoDto);
        }
        return list;*/