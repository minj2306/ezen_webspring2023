package example.객체연관관계;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter  @Builder @ToString // 기본값으로 객체 참조값 호출 // @ToString 사용시
public class 회원 {

    private int 회원번호;
    private String 회원아이디;
    private String 회원이름;
    // 리스트 : 1명 회원(객체)은 여러게의 게시물 가질수 있으니까
    @Builder.Default // 빌더패턴 사용시 해당 필드는 기본값으로 사용
    @ToString.Exclude  //해당 필드는 @ToString.Exclude 제외
    private List<게시물> 내가쓴글 = new ArrayList<>();

}
