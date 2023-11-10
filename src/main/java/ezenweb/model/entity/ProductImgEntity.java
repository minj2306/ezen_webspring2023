package ezenweb.model.entity;

import lombok.*;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table( name ="productimg")
public class ProductImgEntity extends BaseTime {/*제품이미지파일*/

    @Id
    private String uuidFileName; // 이미지 식별 이름 [pk]
    @Column
    private String realFileName; // 이미지 실제 이름

    @JoinColumn( name = "pno")
    @ManyToOne
    private ProductEntity productEntity;
}