package example.과제;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno;
    private String pname;
    private String pnumber;

}
