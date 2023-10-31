package ezenweb.model.repository;

import ezenweb.model.dto.MemberDto;
import ezenweb.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberEntityRepository extends JpaRepository<MemberEntity, Integer> {

    // 인터페이스!!!!!!!추상메소드
    // - 이메일 이용한 엔티티/레코드 검색 select * from member where memail = 변수
    // 반환 자료형 추상 메소드( 매개변수 )
    // 1, 필드명을 이용한 엔테테 검색 : 반환 엔티티 findBy필드명(매개변수)

        // 1. 동일한 이메일 있을때 엔티티 반환 없을때 null 반환
    //MemberEntity findByMemail( String memail );

        // 2. 동일한 이메일 있을때 Optional 반환 없을때 Optional 반환
    MemberEntity findByMemail( String memail );

        // 3. 동일한 이메일 있을떄 TRUE 없을때 FALSE 반환
    boolean existsByMemail( String memail );

        // 4. 조건에 and/or 있을때 이메일과 이름 이 같을떄
        // select * from member where mname = 변수 and memail = 변수;
    //MemberEntity findByMnameAndMemail( String mname, String memail );

    /////////////////////////////////////////////////////////////////
    Optional<MemberEntity> findByMnameAndMpassword(String mname, String mpassword);

    Optional<MemberEntity> findByMemailAndMphone(String memail, String mphone);

    Optional<MemberEntity> findByMemailAndMpassword( String memail, String mpassword);


}
