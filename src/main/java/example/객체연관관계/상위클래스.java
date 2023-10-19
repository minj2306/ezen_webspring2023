package example.객체연관관계;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class 상위클래스 {

    private String data;
    @Builder.Default //빌더패턴 사용시 기본값으로 사용
    private List<하위클래스> 참조하위객체들 = new ArrayList<>();


}
