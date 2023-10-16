package ezenweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JAP Auditing
@SpringBootApplication // 스프링 부트 실행해주는 기능 주입 [ 다양한 기능 제공 ]
public class EzenWebStart {

    public static void main(String[] args) {
        SpringApplication.run(EzenWebStart.class);
    }
}