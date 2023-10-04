package day02.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// JSP 프로젝트에서 자동으로 서블릿클래스 멤버 구성해줌
    // @WebServlet( name = "서블릿 이름[ 생략시 클래스명으로 자동 ]" , urlPatterns = "서블릿 연력한 HTTP 경로" )
    // @WebServlet( "day02/my ) // JSP 프로젝트때 사용했던 방식
@WebServlet( name = "MyServlet" , urlPatterns = "/day02/my")//브라우저의 경로와 해당 서블릿을 연결하는 설정을 위해서 사용
public class MyServlet extends HttpServlet {

    // 서블릿 생성 방법
    // 1. @WebServlet
    // 2. extentds HttpServlet
        // 해당 HttpServlet 클래스로부터 다양한 rest 메소드를 상속받음
    // 3. 오른쪽 클릭 -> 생성 -> 메소드 재정의 [ doget , dopost , doput , dodelete 등등 ]


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");
        // resp.getWriter().println(); 아래코드와 같은 형식
        PrintWriter out = resp.getWriter();
        out.println("<html>");
            out.println("<body>");
                out.println("<h1>안녕 서블릿</h1>");
            out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}


/*
    p.28 Tip
        @ : 어노테이션
                - 주석이나 해석으로 할 수 있는데 주로 코드상에 추가적인 정보를 남겨두기 위해서 사용
                - 특정한 코드에 대해 추가적인 처리나 설정을 위해서 사용
                - 특정 클래스에 추가적인 외부기능 부여할때 상속/구현체보다 확장성이 좋다.
                
        - 다른 클래스에게 데이터 전달하는 방법
            - extends : 상속 [ 클래스 설계도 연장 ]
            - implements : 구현 [ 인터페이스의 추상메소드 구현체 ]
                - 클래스 상속과 인터페이스 구현 한계...
                    1. 클래스는 상속 1번만 가능
                    2. 인터페이스는 메모리 전달 불가능..[ 일반 필드를 가질수 없다. 무조건 상수 ]
            - @어노테이션
                1. 빌트인      @Override : JDK내 내장(기능) 된 어노테이션 
                2. 메타데이터 : 외부 라이브러리나 생성된 어노테이션 : 인터페이스나 클래스들을 확장해서 구조화된 데이터를 전달해주는
                3. 사용자정의 : 개발자가 생성한 어노테이션
*/