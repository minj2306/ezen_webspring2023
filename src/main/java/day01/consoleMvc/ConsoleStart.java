package day01.consoleMvc;

import java.util.List;
import java.util.Scanner;

public class ConsoleStart {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        while (true){

            doGet();
            doPost();

        }// wh end

    }// main end

    public static void doGet(){

        ConsoleController controller = new ConsoleController();

        List<ConsoleDto> result = controller.doGet();

        System.out.println(result);
    }

    public static void doPost(){

        System.out.println("title : ");
        String title = scanner.next();

        ConsoleController controller = new ConsoleController();

        boolean result = controller.doPost(title);
        System.out.println(result);
    }

}// class end
/*
//syso : 이클립스 자동완성
//sout : 인텔리제이 자동완성

        System.out.println("sout -> println");
                System.out.printf("souf -> printf");
                System.out.println("consoleStart.main"); // soutm : 현재 실행중인 함수명 호출
                System.out.println("args = " + Arrays.toString(args)); // soutp 현재 실행중인 함수의 매개변수 호출
                System.out.println("args = " + args); // soutv 변수 출력
// ctrl + shift + F10 또는 왼쪽의 실행 화살표
*/
