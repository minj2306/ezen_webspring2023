package ezenweb.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table( name ="productcategory" )
public class ProductCategoryEntity extends BaseTime {/*제품 카테고리*/

    @Id@GeneratedValue( strategy = GenerationType.AUTO)
    private int pcno; // 카테고리 번호 [ pk ]
    @Column
    private String pcname; // 카테고리 명
    @OneToMany( fetch = FetchType.LAZY , mappedBy = "productCategoryEntity" , cascade = CascadeType.ALL)
    @ToString.Exclude
    List<ProductEntity> productEntityList = new ArrayList<>();

    /*
        fetch : 양방향일때 참조를 불러오는 로딩 옵션
            fetch = FetchType.LAZY            : 참조를 사용할 때 로딩 [ 지연 로딩 ] 자바에서 .get~~ 할 때 객체 참조해서 불러오는 방식
            fetch = FetchType.EAGER [ 기본값 ] : 참조값을 즉시 로딩 [ 즉시 로딩 ] db에서 select 할때 객체 참조해서 불러오는 방식

        cascade : 영속성 제약조건 ( 엔티티 객체기준 ) : 서로 연관된 객체들 끼리 ( 부-자 ) 의 영향을 끼치게 할건지
            [ REMOVE , PERSIST  ]cascade = CascadeType.ALL : REMOVE 와 PERSIST 둘다 적용
            [ 모두제거 ]cascade = CascadeType.REMOVE : 부모가 삭제될때 자식도 같이 삭제 [ 부모와 자식 엔티티를 모두 제거 ]
            [ 영속성 ]cascade = CascadeType.PERSIST : 부모 호출 할 때 자식도 같이 호출 [ 부모와 자식 엔티티를 한번에 영속화 ]
                - 부모를 저장하면 자식도 같이 저장
            [ 새로고침 ]cascade = CascadeType.REFRESH : 부모의 객체가 업데이트 되면 자식객체 값 새로고침
            [ 영속성제거 ]cascade = CascadeType.DETACH : 영속성제거
            [ 병합 ]cascade = CascadeType.MERGE : 부모가 객체가 수정될때 자식객체도 조회 후 업데이트
            
    */

}
