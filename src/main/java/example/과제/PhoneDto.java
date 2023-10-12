package example.과제;

import lombok.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PhoneDto {

    private int pno;
    private String pname;
    private String pnumber;

}
