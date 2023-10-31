package ezenweb.model.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @Builder
@Entity
@Table( name = "producer" )
public class ProducerEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int prno; // 거래처 번호

    @Column( name = "prname" , length = 20 , nullable = false)
    private String prname; // 거래처이름

}
