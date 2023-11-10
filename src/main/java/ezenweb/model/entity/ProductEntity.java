package ezenweb.model.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
@Table(name ="product")
public class ProductEntity extends BaseTime {/*제품테이블*/

    @Id
    private String pno; // 제품번호 [ pk ]
    @Column
    private String pname; // 제품명
    @Column( columnDefinition = "TEXT")
    private String pcomment; // 제품 설명
    @Column
    private int pprice; // 제품 가격
    @Column
    @ColumnDefault("0")
    private byte pstate; // 제품 상태
    @Column
    @ColumnDefault("0")
    private int pstock; // 제품 재고

    @JoinColumn( name = "pcno")
    @ManyToOne
    private ProductCategoryEntity productCategoryEntity;

    @OneToMany( fetch = FetchType.LAZY , mappedBy = "productEntity" , cascade = CascadeType.ALL)
    @ToString.Exclude
    List<ProductImgEntity> productImgEntities = new ArrayList<>();
    //@OneToMany( mappedBy = "fk 사용중인 엔티티 클래스 필드명" )
}
