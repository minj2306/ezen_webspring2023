package example.day05;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // JPA(ORM매핑) MYSQL 테이블과 매핑
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TodoEntity {

    @Id // pk로 선정할 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    private int tno;
    private String tcontent;
    private boolean tstate;
    
    
}
