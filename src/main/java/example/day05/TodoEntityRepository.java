package example.day05;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// * 엔티티 조작하는 (인터페이스) 리모컨 만들기
@Repository //스프링 컨테이너에 빈등록
public interface TodoEntityRepository extends JpaRepository< TodoEntity ,Integer > {



}
