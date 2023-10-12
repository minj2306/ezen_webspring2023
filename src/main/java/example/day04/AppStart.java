package example.day04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    메타 어노테이션 ?? : 실행 또는 컴파일 했을때 사용방법(이미 설치된 라이브러리) 에 대해 정의
*/
@SpringBootApplication // @ComponentScan [ @Controller , @RestController , @Service , @Repository , @Configure 등록 ]
// 모든 컴포넌트들을 찾아서 빈등록
public class AppStart {

    public static void main(String[] args) {
        SpringApplication.run( AppStart.class );
    }

}

/*
    스프링이 view(정적) 파일들을 찾는 위치 resoursces 폴더
        -주의할 점 : 본인이 만들고 싶은곳데 정적(view) 파일 만들면 안된다.
    HTML : resources -> templates -> html 파일
    JS/CSS/Image : resources -> static -> JS/CSS/Image 파일

    - JSP 프로젝트와 SPRING 프로젝트의 정적파일 경로 차이
        - JSP는 패키지의 경로와 파일명이 곧 URL 
        
        - SPRING 은 정적팡리 호출하는 URL 매핑
            매핑후 Resource 반환
*/