package ezenweb.model.dto;


import ezenweb.model.entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto {

    private int mno;    // 회원번호
    private String memail; // 이메일 [회원 아이디 대체]
    private String mpassword; // 비밀번호
    private String mname; // 이름
    private String mphone; // 연락처
    private String mrole; // 회원등급 ( 일반회원 =  "user" , 관리자 회원 =  "admin" )

    private LocalDateTime cdate;
    private LocalDateTime udate;
    // dto -- > entity 반환함수
        // service 에서 dto 정보를 db 테이블 매핑에 저장하기 위해서
    public MemberEntity toEntity(){
        return MemberEntity.builder()
              .mno(this.mno)
              .memail(this.memail)
              .mpassword(this.mpassword)
              .mname(this.mname)
              .mphone(this.mphone)
              .mrole(this.mrole)
              .build();
    }
}
