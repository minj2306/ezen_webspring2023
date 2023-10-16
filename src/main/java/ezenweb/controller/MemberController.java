package ezenweb.controller;

import ezenweb.model.dto.MemberDto;
import ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
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
    @GetMapping("/get")
    public MemberDto getMember( @RequestParam int mno){

        MemberDto memberDto = memberService.getMember(mno);
        return memberDto;
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

    @PostMapping("/login")
    public boolean login(@RequestBody MemberDto memberDto ){

        boolean result = memberService.login(memberDto);

        return result;

    }

    @GetMapping("/logout")
    public boolean logout( @RequestParam int mno ){

        boolean result = memberService.logout(mno);

        return result;

    }



}
