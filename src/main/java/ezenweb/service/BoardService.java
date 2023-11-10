package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.MemberDto;
import ezenweb.model.dto.PageDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.BoardEntityRepository;
import ezenweb.model.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardEntityRepository boardEntityRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberEntityRepository memberEntityRepository;

    @Transactional //함수내 여럿 SQL을 하나의 일처리 단위로 처리
    public boolean write( BoardDto boardDto ){

        // 2. pk 번호를 가지고 pk 엔티티 찾기
        //--------------------단방향-------------------------------

        MemberDto loginDto = memberService.getMember();
        if( loginDto==null){ return false; }

        Optional<MemberEntity> memberEntityOptional =
                memberEntityRepository.findById( memberService.getMember().getMno() );

        // 3. 유효성 검사 [ 로그인이 안된 상태 - 글쓰기 실패 ]
        if( !memberEntityOptional.isPresent() ){ return false; }
        // 4. 단방향 저장
            // 1. 게시물 생성
        // 게시물 앤티티 등록
        BoardEntity boardEntity =
                     boardEntityRepository.save( boardDto .saveToEntity() );
            // 2. 생성된 게시물에 작성자 엔티티 넣어주기
        boardEntity.setMemberEntity( memberEntityOptional.get() );
        //-----------------------------------------------------------------
        //-----------------양방향--------------------------------------
        // 5. 양방향 저장
        memberEntityOptional.get().getBoardEntityList().add( boardEntity);

        //----------------------------------------------------------
        if( boardEntity.getBno() >= 1 ){
            // 게시물 쓰기 성공시 파일처리
            String fileName =
                    fileService.fileUpload( boardDto.getFile() );
            if( fileName != null ){
                boardEntity.setBfile( fileName );
            }
            return true;
        }
        return false;
    }
    @Autowired
    FileService fileService;

    // 2.
    @Transactional
    public PageDto getAll( int page , String key , String keyword , int view ){

        // * JPA 페이징처리 라이브러리 지원
            // 1 . Pageable : 페이지 인터페이스( 구현체 : 구현[ 추상메소드(인터페이스 가지는 함수) 를 구현] 해주는 객체)
            // 2.  PageRequest : 페이지 구현체
                //of (현재 페이지 , 페이지별 게시물수
                // 현재 페이지 0부터 시작
                // 페이지별 게시물 수 : 만약 2일때는 페이지마다 게시물 2개씩 출력
            // 3. Page : list와 마찬가지로 여러개의 객체를 저장하는 타입
                // list 와 다르게 추가적으로 함수 지원
                    // 1. getTotalPages()
                    // 2. getTotalElements()
            // new 안씀 -> of 가 static이기 떄문  페이지 번호 , 출력수   정렬기준                 방식  정렬기준 필드명
        Pageable pageable = PageRequest.of( page-1 , view  /*, Sort.by(Sort.Direction.DESC , "cdate") */ );
        System.out.println("page : " + page);
        // 1. 모든 게시물 호출한다.
        //Page <BoardEntity> entities = boardEntityRepository.findAll( pageable );
        Page<BoardEntity> boardEntity = boardEntityRepository.findBySearch( key , keyword , pageable);
        // 2. List<BoardEntity> -> List<BoardDto>
        List<BoardDto> boardDtos = new ArrayList<>();

        // 3.
        boardEntity.forEach( e -> {
            boardDtos.add( e.allToDto() );

        });

        // 3. 총 페이지수
        int totalPage = boardEntity.getTotalPages();
        // 4. 총 게시물 수
        Long totalCount = boardEntity.getTotalElements(); // 요소 : 게시물 1개

        PageDto pageDto = PageDto.builder()
                .boardDtos(boardDtos)
                .totalCount(totalCount)
                .totalPage(totalPage)
                .build();
        System.out.println("pageDto"+pageDto);
        return pageDto;
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

    // 5 [2-2] 개별 게시글 출력
    @Transactional
    public BoardDto doGet( int bno ){

        // PK 변호에 해당하는 엔티티 찾기
        Optional<BoardEntity> boardEntityOptional = boardEntityRepository.findById(bno);

        // 2. 검색된 엔티티가 존재하면
        if(boardEntityOptional.isPresent()){

            // 3. 엔티티 꺼내기
            BoardEntity boardEntity = boardEntityOptional.get();

                // 조회수 증가
                boardEntity.setBview( boardEntity.getBview()+1 );
            // 4. 엔티티 -> DTO 반환
            BoardDto boardDto = boardEntity.allToDto();

            return boardDto;
        }

        return null;
    }

}
