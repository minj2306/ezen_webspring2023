package ezenweb.model.dto;


import ezenweb.model.entity.MemberEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto implements UserDetails , OAuth2User {


    //-------------------------OAuth2User--------------------------

    private Map<String , Object> 소셜회원정보;

    @Override //oauth2 회원의 정보
    public Map<String, Object> getAttributes() {
        return 소셜회원정보;
    }

    @Override // oauth2 회원의 아이디
    public String getName() {
        return memail;
    }

    //-------------------------UserDetails--------------------------

    // Collection : 컬랙션 프레임워크 : set , list , map
    List<GrantedAuthority> 권한목록;

    @Override // 계정 권한 목록 [ 여러개 가능 ]
    public Collection<? extends GrantedAuthority> getAuthorities() { return 권한목록;}

    @Override // 계정 비밀번호
    public String getPassword() { return mpassword; }

    @Override // 계정 아이디
    public String getUsername() { return memail; }

    @Override // 계정 만료 여부
    public boolean isAccountNonExpired() { return true; }

    @Override // 계정 잠금 여부   true 열림 , false 잠김
    public boolean isAccountNonLocked() { return true; }

    @Override // 계정 증명 여부
    public boolean isCredentialsNonExpired() { return true; }

    @Override // 계정 활성화 여부
    public boolean isEnabled() { return true; }

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
