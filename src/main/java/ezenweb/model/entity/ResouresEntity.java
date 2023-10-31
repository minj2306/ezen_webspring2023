package ezenweb.model.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @Builder
@Entity
@Table( name = "resources" )
public class ResouresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resno; // 재료번호

    @Column( name = "resname" , length = 20 , nullable = false)
    private String resname; // 재료 이름

    @Column( name = "resprice" , nullable = false)
    private int resprice; // 재료 가격

    @JoinColumn(name ="rescno")
    private int rescno; // 재료 카테고리


    @JoinColumn(name = "prno")
    private int prno; // 거래처 번호

}
