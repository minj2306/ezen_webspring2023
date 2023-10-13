package example.day06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 다양한 기능 [ application.properties 파일 (톰캣포트, JSP 연동) 을 스캔해서 프로젝트에 등록 ]
public class NoteStart {

    public static void main(String[] args) {

        SpringApplication.run(NoteStart.class);

    }
}
