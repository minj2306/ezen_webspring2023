package example.Order.entity;

import example.Order.entity.Category;
import example.Order.entity.Order;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table( name = "product")
public class Product {
    // 제품 번호
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int pno;
    // 제품 이름
    @Column( name = "pname", length = 40, nullable = false)
    private String pname;
    // 카테고리 FK
    @ToString.Exclude
    @JoinColumn( name = "cno_fk" )
    @ManyToOne
    private Category category;
    // 재고 FK
    @OneToOne(mappedBy = "pㄴㅊroduct")
    private Order order;

}
