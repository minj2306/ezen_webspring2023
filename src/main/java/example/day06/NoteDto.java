package example.day06;


import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NoteDto {

    private int no;//게시물 번호
    private String title;//게시물 내용
    private String writer;//작성자
    private String password;//패스워드
    private LocalDateTime date;//작성일
    // DB는 없지만 추가적으로 필요한 코드

    // * dto 를 엔티티로 변환해주는 함수[service 에서 사용]
    public NoteEntity toEntity(){
        return  NoteEntity.builder()
                .date(this.date)
                .password(this.password)
                .no(this.no)
                .writer(this.writer)
                .title(this.title)
                .build();
    }

}
