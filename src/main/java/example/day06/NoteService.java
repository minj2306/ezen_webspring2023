package example.day06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteEntityRepository noteEntityRepository;

    // 1. C
    @Transactional
    public boolean bWrite( NoteDto noteDto){

        // 1. dto --> 엔티티 변경

        noteEntityRepository.save( noteDto.toEntity() );
        return false;
    }

    // 2, R
    @Transactional
    public List<NoteDto> bList(){

       //1. 모든엔티티 호출하기
       List<NoteEntity> entities = noteEntityRepository.findAll();
       //2. 모든 엔티티 릿스트 -> dto 리스트 반환
        List<NoteDto> noteDtos = new ArrayList<>();
        //3. 엔티티 -> dto 변경후 리스트에 담기
        entities.forEach( e ->{
            noteDtos.add( e.toDto());
        });
        return noteDtos;
    }

    // 3. U
    //@Transactional 해당 주입된 함수 내에서 사용중인 SQL를 트랜젝션 단위로 적용
    @Transactional // 트랜잭션 : 하나/여럿 작업들을 묶어서 최소단위 업무처리
    public boolean bUpdate( NoteDto noteDto ){
        // 1. 수정할 pk 번호에 해당하는 엔티티 찾기
        Optional<NoteEntity> optionalNoteEntity =
                            noteEntityRepository.findById( noteDto.getNo());
        // 2. 포장내 내용물이 있는지 체크 = 안전하게 검토..과정
        if( optionalNoteEntity.isPresent()){
            // 3. 포장내 내용물 꺼내기 = 포장된곳에서 엔티티 꺼내는 과정
            NoteEntity noteEntity = optionalNoteEntity.get();
            //4. 수정 별도의 수정함수 필요x
            noteEntity.setTitle( noteDto.getTitle());
            noteEntity.setWriter( noteDto.getWriter());
        }
        return false;
    }

    // 4. D
    @Transactional
    public boolean bDelete( int no ){
        //1. 삭제할 pk 변호를 대입하여 엔티티 삭제
        noteEntityRepository.deleteById(no);
        return false;
    }
}
