package example.day01.Lombok;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor // 빈생성자 자동생성
@AllArgsConstructor // 풀생성자 자동생성
@Getter // getter , setter 메소드 자동생성
@Setter
@ToString // toString 자동 생성
@Builder // 빌더패턴
public class LombokDto {
    private int no; // todo 번호
    private String title; // todo 내용
    private LocalDate dueDate; // todo 작성일
    private boolean finished; // todo 실행여부

}
