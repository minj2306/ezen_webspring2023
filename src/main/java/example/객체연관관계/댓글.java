package example.객체연관관계;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder @ToString
public class 댓글 {

    private int 댓글번호;
    private String 댓글내용;
    private 게시물 댓글게시물;
    // 게시물은 1명의 회원 작성하므로 리스트 아니다.
    @ToString.Exclude // 주로 참조객체에 @ToString 제외 권장
    private 회원 작성한회원;
}
