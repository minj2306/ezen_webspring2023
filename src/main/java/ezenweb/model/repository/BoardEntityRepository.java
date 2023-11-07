package ezenweb.model.repository;

import ezenweb.model.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardEntityRepository
                                        // 조작할엔티티 , 조작할 엔티티의 pk의 필드 타입
                        extends JpaRepository<BoardEntity, Integer> {
    // 추상메소드 이용한 엔티티 검색
    // 1. 해당하는 제목의 엔티티 찾기
    BoardEntity findByBtitle(String btitle);
    //Optional<BoardEntity> findByBtitle(String btitle);
    boolean existsByBtitle(String btitle);
    // + 페이징 처리
    //List<BoardEntity> findByAllBtitle(String btitle , Pageable pageable);

    Page<BoardEntity> findByBtitle(String btitle , Pageable pageable);
    // + mysql 실제 SQL 작성하기 @Query
        // @Query( value = "SQL" 작성 , nativeQuery = true )
        // nativeQuery = true 사용하면 실제 mysql에서 사용하는 sql 표현식 사용
    // SQL 안에서 매개변수를 표현할때 :매개변수명
    @Query( value = "select * from board " +
            "where btitle like %:keyword%" ,
            nativeQuery = true)
    Page<BoardEntity> findBySearch( String key , String keyword , Pageable pageable );

}



