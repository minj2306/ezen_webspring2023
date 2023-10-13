package example.teamTask;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
@Builder
public class CarDto {
    private int cno; // 차량식별키
    private String cnumber; // 차량번호
    private String ctype; // 차량종류
    private LocalDateTime ctime; // 주차시간
    // DTO 엔티티 변환
    public CarEntity toEntity(){
        return CarEntity.builder()
                .cno(this.cno)
                .cnumber(this.cnumber)
                .ctype(this.ctype)
                .ctime(this.ctime)
                .build();

    }
}
