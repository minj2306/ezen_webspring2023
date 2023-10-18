package ezenweb.model.entity;

import ezenweb.model.dto.BoardDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;


// 1. 엔티티를 이용한 테이블 생성할때
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @Builder
@Entity // 해당 클래스를 엔티티로 사용
@Table( name = "board" ) // 테이블 명 설정
@DynamicInsert // @ColumnDefault 가 적용될수 있도록 해주는 어노테이션
public class BoardEntity extends BaseTime { // 테이블 설계
    // 필드 설계

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) //
    private int bno;
    @Column( name = "btitle" , length = 200 , nullable = false ) // 생략 가능 [ 필드 속성을 커스텀 하기 위해서 작성 ]
    private String btitle;
    @Column( columnDefinition = "longtext" ) //db에서 longtext 사용하는데.. java 문자열 처리가 String[255 최대] 밖에 없네..
    private String bcontent;
    @Column
    @ColumnDefault("0") // "'문자처리'" vs "숫자"
    private int bview;
    // private LocalDateTime bdate; // BaseTime 클래스로부터 상속 받으면 자동
    // BaseTime 클래스가 상속해주는 필드 : 1. 작성일 2. 수정일
    @Column( columnDefinition = "longtext" )
    private String bfile;
    private int mno;

    // entity -> dto [ 상황에 따라 여러개 선언 ]
    // 1.[전체 => 게시판 출력 페이지 ] 출력 할 때
    public BoardDto allToDto(){
        return BoardDto.builder()
                        .bno(this.bno)
                        .btitle(this.btitle)
                        .bcontent(this.bcontent)
                        .bfile(this.bfile)
                        .bview(this.bview)
                        .mno(this.mno)
                        .cdate(this.getCdate())
                        .udate(this.getUdate())
                        .build();
    }

    //2. [개별 => 개별 게시판 ] 출력 할 때

}


/*
    2. 직접 DDL 작성해서 테이블 생성할때
    create table board (
                        bno int
                        btitle varchar(255) ,
                        bcontent varchar(255),
                        bview int
                        cdate datetime default now() ,
                        bdate datetime default now()
                        bfile longtext ,
                        mno int ,
                        primary key (bno)
                        )

    3. 실제 jpa 가 엔티티클래스를 이용한 테이블 생성할때 사용된 SQL
        create table board (
                            bno integer not null auto_increment,
                            cdate datetime(6),
                            udate datetime(6),
                            bcontent longtext,
                            bfile longtext,
                            btitle varchar(200) not null,
                            bview integer default 0,
                            mno integer not null,
                            primary key (bno)
                            )

*/