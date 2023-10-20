package example.Order.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "porder")
public class Order {
    // 주문 번호
    // 주문 가격
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int ono;

    @Column(name = "oprice" , nullable = false)
    private int oprice;

    // 제품 FK
    @ToString.Exclude
    @JoinColumn(name = "pno_fk" )
    @OneToOne
    private Product product;
}
