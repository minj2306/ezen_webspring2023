package example.day02.servlet;

import lombok.*;

import java.time.LocalDate;

//롬복 라이브러리 설치 되었다는 가정하에
@Getter // 각 필드별 get 메소드 자동 생성
@Setter // 각 필드별 set 메소드 자동 생성
@ToString // 객체의 필드 정보를 출력하는 toString 메소드 자동 생성
@AllArgsConstructor //풀 생성자 
@NoArgsConstructor // 빈 생성자
@Builder // 빌더패턴 : 객체 생성시 사용할수 있는 함수
public class TodoDto {
    
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    
}
