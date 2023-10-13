package example.teamTask;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno; // 차량식별키
    private String cnumber; // 차량번호
    private String ctype; // 차량종류
    private LocalDateTime ctime; // 주차시간
    // 엔티티 DTO 변환
    public CarDto toDto(){
        return new CarDto(this.cno, this.cnumber, this.ctype, this.ctime);

    }
}
