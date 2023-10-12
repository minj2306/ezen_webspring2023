package example.day01.Lombok;

import example.day01.consoleMvc.ConsoleDto;

import java.time.LocalDate;

public class LombokTest {

    public static void main(String[] args) {

        // - 롬복이 없을때 DTO
        // 1. 빈생성자로 객체 생성
        ConsoleDto consoleDto1 = new ConsoleDto();

        // 2. 풀생성자로 객체 생성
        ConsoleDto consoleDto2 = new ConsoleDto(0 ,"공부" , LocalDate.now() , true);

        // 3. getter , setter 메소드 사용할때
        consoleDto1.setTitle("공부하기");
        consoleDto1.getTitle();
        // 4. Tostring() 메소드 사용할때
        System.out.println( consoleDto1 );

        // 5.
            // 1. 빈생성자 또는 풀생성자가 아닌 [ 정의된 생성자가 아닌 수제 생성자를 사용하고 싶을때 생성자 정의 해야만 가능 ]
            // ConsoleDto consoleDto3 = new ConsoleDto( "공부" , true ); //생성된(정의된) 생성자만 사용할수 있다

            // 2. 생성자는 매개변수의 순서가 다르면 오류가 발생
            // ConsoleDto consoleDto4 = new ConsoleDto( true ,  "공부" , 0 , LocalDate.now() );


        // - 롬복이 있을떄 DTO
        LombokDto lombokDto1 = new LombokDto();
        LombokDto lombokDto2 = new LombokDto(0 ,"공부" , LocalDate.now() , true);
        lombokDto1.setTitle("자바공부");
        lombokDto1.getTitle();
        System.out.println( lombokDto1 );
        // * 빌더 패턴 : 복잡한 객체 생성과정[생성자] 을 다양한 구성의 객체를 만드는 패턴 지원 [ builder() 함수 지원 ]
        LombokDto lombokDto3 = LombokDto.builder().title("공부").finished(true).build();
        LombokDto lombokDto4 = LombokDto.builder()
                                            .finished(true)
                                            .title("공부")
                                            .dueDate(LocalDate.now())
                                            .no(0)
                                            .build();

    }

}
