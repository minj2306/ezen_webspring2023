package example.객체연관관계;


import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder
public class 게시물 {

    private int 게시물번호;
    private String 게시물제목;
    private String 게시물내용;
    private 회원 작성한회원; // 회원객체의 주소값 가지는 필드 [참조필드]

}
