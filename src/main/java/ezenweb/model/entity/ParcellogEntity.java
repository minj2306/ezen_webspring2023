package ezenweb.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @Builder
@Entity
@Table(name = "parcel_log")
public class ParcellogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pano; // 발주  식별 번호

    @Column( name = "pcount" , nullable = false)
    private int pacount; // 주문 개수

    @JoinColumn(name = "resno")
    private int resno; // 재료번호 fk


    @Column( name = "pasdate")
    private LocalDateTime pasdate; // 주문 날짜

    @Column( name = "paedate" )
    private LocalDateTime paedate; // 도착 날짜

}
