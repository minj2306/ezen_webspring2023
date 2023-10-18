package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.repository.BoardEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardEntityRepository boardEntityRepository;

    @Transactional //함수내 여럿 SQL을 하나의 일처리 단위로 처리
    public boolean write( BoardDto boardDto ){

        // 1. dto -> entity 변환후 저장된 엔티티 반환
        BoardEntity boardEntity =
                     boardEntityRepository.save( boardDto.saveToEntity() );

        if( boardEntity.getBno() >= 1 ){
            return true;
        }
        return false;
    }

    // 2.
    @Transactional
    public List<BoardDto> getAll(){

        // 1. 모든 게시물 호출한다.
        List<BoardEntity> entities = boardEntityRepository.findAll();
        // 2. List<BoardEntity> -> List<BoardDto>
        List<BoardDto> boardDtos = new ArrayList<>();
        // 3.
        entities.forEach( e -> {
            boardDtos.add( e.allToDto() );
        });
        return boardDtos;
    }

    // 3.
    @Transactional // !!!!put 은 @Transactional 필수 : 수정은 하나의 함수에 sql 여러개 실행될 경우가 있어서
    public boolean update( BoardDto boardDto ){

        // 1. 수정할 엔티티 찾기 [ bno 해서 ]
        Optional<BoardEntity> optionalBoardEntity =
                            boardEntityRepository.findById( boardDto.getBno());
        // 2. 만약에 수정할 엔티티가 존재하면
        if(optionalBoardEntity.isPresent()){

            // 3. 엔티티 꺼내기
            BoardEntity boardEntity = optionalBoardEntity.get();

            //4. 엔티티 객체를 수정하면 테이블 내 레코드도 같이 수정 [ + 매핑 => ORM ]
            boardEntity.setBtitle( boardDto.getBtitle());
            boardEntity.setBcontent( boardDto.getBcontent());
            boardEntity.setBfile( boardDto.getBfile());

            return true;
        }

        return false;
    }

    // 4.
    @Transactional
    public boolean delete( int bno ) {
        // 1. 엔티티 존재여부 확인
        Optional<BoardEntity> optionalBoardEntity =
                boardEntityRepository.findById(bno);

        if (optionalBoardEntity.isPresent()) {

            boardEntityRepository.deleteById(bno);

            return true;
        }
        return false;
    }
}
