package ezenweb.model.repository;

import ezenweb.model.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardEntityRepository
                                        // 조작할엔티티 , 조작할 엔티티의 pk의 필드 타입
                        extends JpaRepository<BoardEntity, Integer> {


}



