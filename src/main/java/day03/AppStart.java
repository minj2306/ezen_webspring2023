package day03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class AppStart {

    public static void main(String[] args) {

        SpringApplication.run( AppStart.class ); // 스프링 부트 작동

    }

}
