package example.day05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoEntityRepository todoEntityRepository;
    //트랜젝션 : 최소단위 일처리 => 결과 [ 성공 , 실패 ]
    @Transactional
    public boolean doPost(TodoDto todoDto){

        // 1. DTO 를 Entity 로 변환
            // 빌더패턴 사용하는 방법
            // 클래스명 객체명 = 클래스명.builder().저장할필드명(저장할뎉이터).build();

        TodoEntity todoEntity = TodoEntity.builder()
                                        .tcontent(todoDto.getTcontent())
                                        .tstate(todoDto.isTstate())
                                        .build();
        todoEntityRepository.save( todoEntity );
        return false;
    }
    @Transactional
    public List<TodoDto> doGet(){
       
        // 1. 모든 엔티티 호출 
       List<TodoEntity> todoEntities = todoEntityRepository.findAll();
       // 2. List<TodoEntity> -> List<TodoDto> 변환 
       List<TodoDto> list = new ArrayList<>();
        
       // 엔티티 리스트에서 엔티티 하나씩 꺼내기 
       todoEntities.forEach( (entity) -> {

           // 3. 엔티티를 DTO로 변환
           TodoDto todoDto = TodoDto.builder()
                   .tno( entity.getTno() )
                   .tcontent( entity.getTcontent() )
                   .tstate( entity.isTstate() )
                                    .build();
           // 변환된 dto를 리스트에 저장
           list.add( todoDto );

       });
       return list;
    }
    @Transactional
    public boolean doPut( TodoDto todoDto){

        // 1. 수정할 엔티티 찾기
        Optional<TodoEntity> todoEntity =
                todoEntityRepository.findById(todoDto.getTno());

        // 2. Optional 객체에 엔티티 존재여부 확인[안전성보장]
        if( todoEntity.isPresent() ){
            // 3. Optional 객체에 엔티티 꺼내기
            TodoEntity updateEntity = todoEntity.get();
            // 4. 엔티티 찾았으니 필드 수정[상태필드만 수정]
            updateEntity.setTstate(todoDto.isTstate());
        }

        return false;
    }
    @Transactional
    public boolean doDelete(int tno){

        // 1. 삭제할 엔티티 찾기[삭제할 pk 번호 ]
        todoEntityRepository.deleteById( tno); // 1. tno[pk 필드번호] 에 해당하는 엔티티 삭제 [ delete 대체]

        return false;
    }
}
