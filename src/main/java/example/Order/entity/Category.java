package example.Order.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table( name = "category" )
public class Category {
    // 카테고리 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;
    // 카테고리 이름
    @Column(name = "cname" , length = 40 , nullable = false)
    private String cname;
    // 제품리스트
    @Builder.Default
    @OneToMany( mappedBy = "category" )
    private List<Product> productList = new ArrayList<>();

}
