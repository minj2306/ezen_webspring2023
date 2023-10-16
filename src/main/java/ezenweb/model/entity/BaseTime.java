package ezenweb.model.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
// 공통된 어노테이션 정보 [ @CreatedDate , @LastModifiedDate ] 등을 부모 클래스로 선언하고 어노테이션 정보를 자식클래스에게 제공
@MappedSuperclass //엔티티 x [ 여러 엔티티가 공통으로 사용하는 필드에 대해 구성할때 ]
@EntityListeners( AuditingEntityListener.class ) //
@Getter
public class BaseTime {

    @CreatedDate // 엔티티가 생성될때 시간이 자동 저장/주입
    private LocalDateTime cdate; // 레코드/엔티티 생성 날짜
    @LastModifiedDate // 엔티티가 변경될때 시간이 자동 저장/주입
    private LocalDateTime udate; // 레코드/엔티티 수정 날짜

}

/*
    BaseTime : 주로 엔티티의 생성/수정 일시를 감지해서 자동으로 업데이트 해주는 클래스
     어노테이션
        1. @CreatedDate : 엔티티가 생성될때 시간이 자동 저장/주입
        2. @LastModifiedDate : 엔티티가 변경될때 시간이 자동 저장/주입
        3. @MappedSuperclass : JPA 엔티티 클래스들의 공통 필드 상속할때 사용하는 어노테이션[ 부모클래스의 매핑 정뵈를 자식클래스에게 제공 ]
        4. @EntityListeners(AuditingEntityListener.class) : 해당 클래스에서 엔티티 감지기능
           - @EntityListeners : 엔티티에서 특정 이벤트가 발생할떄마다 특정로직 실행
           - AuditingEntityListener.class : 감지 이벤트 실행
                - insert( @CrreateDate ) 와 update[ @LastModifiedDate ] 할때
            + @EnableJapAuditing : Spring data JPA Auditing 을 이용한 엔티티 감지
                - @SpringBootApplication 어노테이션 같은 위치에서 선언

*/