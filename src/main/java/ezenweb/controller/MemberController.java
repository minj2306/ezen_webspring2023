package ezenweb.controller;

import ezenweb.model.dto.MemberDto;
import ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

// IOC(Inversion Of Controller) : 제어역전 ( 객체관리를 Spring 에게 위임 ) => 왜?? 개발자가 편하려고 / 협업하려고( 객체 공유햇거 쓸려고 = 서로 다른 객체 사용했을떄 문제발생=싱글톤
// DI( Depwndenct injection ) : 의존성 주입 [ 스프링이 객체를 관리하니까.. 스프링에게 객체를 의존(부탁) 해서 주입(가져오기) ]
@RestController // 컨트롤러 (@Cmomponent 포함= 스프링 컨테이너(스프링 관리하는 메몰리 공간) 빈(겍체) 등록 ) + ResponseBody
@RequestMapping("/member")
//@CrossOrigin("http://localhost:3000") // 교차 리스트 공유(
public class MemberController {

    // Controller -> Service 요청
    // Controller <- Service 응답
    @Autowired
    private MemberService memberService;


    // [C] 회원가입
    @PostMapping("/post")
    public boolean postMember( @RequestBody MemberDto memberDto ){

        boolean result = memberService.postMember(memberDto);
        return result;
    }


    // [R]  회원정보 호출
    /*@GetMapping("/get")
    public MemberDto getMember( @RequestParam int mno){

        MemberDto memberDto = memberService.getMember(mno);
        return memberDto;
    }*/

    // 2. 회원정보호출 세션 구현했을때
    @GetMapping("/get")
    public MemberDto getMember (){
        return  memberService.getMember();
    }


    // [U]  회원정보 수정
    @PutMapping("/put")
    public boolean updateMember( @RequestBody MemberDto memberDto){

        boolean result = memberService.updateMember(memberDto);
        return result;
    }

    // [D] 회원탈퇴
    @DeleteMapping("/delete")
    public boolean deleteMember( @RequestParam int mno ){

        boolean result = memberService.deleteMember(mno);
        return result;
    }

    @GetMapping("/getId")
    public String getId( @RequestParam String mname , @RequestParam String mpassword ){

        String result = memberService.getId(mname , mpassword);
        return result;
    }

    @GetMapping("/getpassWord")
    public String getpassWord( @RequestParam String memail , @RequestParam String mphone ){

        String result = memberService.getpassWord(memail, mphone);
        return result;
    }

    /*// 5. 로그인
    @PostMapping("/login")
    public boolean login( @RequestBody MemberDto memberDto ){
        boolean result = memberService.login( memberDto );
        return result;
    }

    // 6. 로그아웃
    @GetMapping("/logout")
    public boolean logout( ){
        boolean result = memberService.logout( );
        return result;
    }*/

    // 7.
    @GetMapping("/findMemail")
    public boolean getFindMemail(
            @RequestParam String memail ){
        System.out.println("memail = " + memail);
        boolean result = memberService.getFindMemail(memail);
        return result;
    }

    //내가 한거
   /* @PostMapping("/login")
    public boolean login(@RequestBody MemberDto memberDto ){

        boolean result = memberService.login(memberDto);

        return result;

    }

    @GetMapping("/logout")
    public boolean logout( @RequestParam int mno ){

        boolean result = memberService.logout(mno);

        return result;

    }*/



}
