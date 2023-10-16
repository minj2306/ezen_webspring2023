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
    Optional<MemberEntity> findByMnameAndMpassword(String mname, String mpassword);

    Optional<MemberEntity> findByMemailAndMphone(String memail, String mphone);

    Optional<MemberEntity> findByMemailAndMpassword( String memail, String mpassword);
}
