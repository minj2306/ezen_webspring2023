package ezenweb.model.entity;

import ezenweb.model.dto.MemberDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity // 해당 클래스를 db 테이블과 매핑 [ 엔티티클래스 <----> db테이블 ( 엔티티 객체 1 개 <-->db 테이블 내 레코드 1개 ) ]
@Table( name = "member") // db테이블 명 정의[ 생략시 해당 클래스명이 곧 db 테이블명으로 자동 생성 ]
public class MemberEntity extends BaseTime {

    @Id // 해당 필드를 pk로 설정
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment
    private int mno;    // 회원번호
    @Column( name = "memail" , length = 50 ,nullable = false , unique = true ) // 해당 필드 선정 [속성]
    // name="필드명" , nullable = false -> not null null 불가 , unique = true 중복 불가
    private String memail; // 이메일 [회원 아이디 대체]

    @Column( length = 30 , nullable = false ) // 해당 필드 선정 [ 최대 30 글자 , not null ]
    private String mpassword; // 비밀번호

    @Column( length = 20 , nullable = false) // 해당 필드 선정 [ 최대 20 글자 , not null ]
    private String mname; // 이름

    @Column( length = 13 , nullable = false , unique = true) // 해당 필드선정 [ 최대 13글자 , not null  , unique ]
    private String mphone; // 연락처

    @Column
    @ColumnDefault( "'user'" ) // @ColumnDefault("기본값") @ColumnDefault("'문자일경우'")
    private String mrole; // 회원등급 ( 일반회원 =  "user" , 관리자 회원 =  "admin" )

    // entity --> dto 반환 함수
        // service 에서 entity 정보를 controller 로 이동하기 위해
    public MemberDto toDto(){

        return  MemberDto.builder()
                .mno(this.mno)
                .memail(this.memail)
                .mpassword(this.mpassword)
                .mname(this.mname)
                .mphone(this.mphone)
                .mrole(this.mrole)
                .cdate(this.getCdate())
                .udate(this.getUdate())
                .build();

    }

}
