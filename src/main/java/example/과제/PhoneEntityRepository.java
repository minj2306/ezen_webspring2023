package example.과제;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneEntityRepository extends JpaRepository< PhoneEntity,Integer> {



}
