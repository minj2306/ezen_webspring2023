package ezenweb.service;

import ezenweb.model.dto.MemberDto;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {

    //---------------------------------------------------//
        // 1. UserDetailsService 구현체
        // 2. 인증처리 해주는 메소드 구현 [ loadUserByUsername ]
        // 3. loadUserByUsername 메소드는 무조건(꼭) UserDetails 객체를 반환해야한다.ㅏ
        // 4. UserDetails 객체를 이용한 패스워드 검증과 사용자 권환을 확인하는 동작(메소드)

    // @Autowired : 사용 불가 ( 스프링 컨테이너에 등록 안된 빈( 객체 ) 이므로 불가능 )
    // PasswordEncoder 스프링 컨테이너 직접등록
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 9. 시큐리티 사용시 인증정보 [로그인상태] 호출
    @Transactional
    public MemberDto getMember(){

        // ! : 시큐리티 사용하기 전에는 서블릿 세션을 이용한 로그인 상태 저장
        // 시큐리티 사용할 떄는 일단 서블릿 세션이 아니고 시큐리티 저장소 이용
        System.out.println( "시큐리티에 저장된 세션 정보 저장소 : "+ SecurityContextHolder.getContext() );
        System.out.println( "시큐리티에 저장된 세션 정보 저장소 저장된 인증 : "
                                + SecurityContextHolder.getContext().getAuthentication() );
        System.out.println( "시큐리티에 저장된 세션 정보 저장소에 저장된 인증 호출 : "
                                + SecurityContextHolder
                                        .getContext()
                                        .getAuthentication()
                                        .getPrincipal() ); // 해당 서비스를 호출한 HTTP
        // * 인증에 성공한 정보 호출 [ 세션 호출 ]
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println( o.toString() );
        // 1. 만약에 인증이 실패했을때 / 없을때 anonymousUser
        if( o.equals("anonymousUser") ) {return null;} // 로그인 안했어
        // 2. 인증결과에 저장된 UserDetails 로 타입 변환
        UserDetails userDetails = (UserDetails) o;
        // 3. UserDetails에 정보를 memberDto 에 담아서 반환
        return MemberDto.builder().memail( userDetails.getUsername() ).build();
    }

    // 8
    @Override
    public UserDetails loadUserByUsername(String memail) throws UsernameNotFoundException {
        System.out.println("MemberService.loadUserByUsername " + memail);

       /* UserDetails userDetails = User.builder()
                                        .username("qweqwe") // 아이디
                                        //.password("1234") // [암호와 없음] 패스워드
                                        .password( passwordEncoder.encode("1234") ) //[암호와 있음] 패스워드
                                        .authorities("ROLE_USER") // 인가(허가나 권한) 정보
                                        .build();*/

        // - p. 684 인증절차 순서
        // 1. 사용자의 아이디만으로 사용자 정보를 로딩 [불러오기] - p.728
        MemberEntity memberEntity = memberEntityRepository.findByMemail( memail );
            // 2. 없는 아이디 이면 // throw : 예외처리 던지기 //
            if( memberEntity == null ){
                throw new UsernameNotFoundException("없는 아이디 입니다.");
            }
        // 2. 로딩[불러오기] 된 사용자의 정보를 이용해서 패스워드를 검증
            // 2-1 있는 아이디이면
        UserDetails userDetails = User.builder()
                .username( memberEntity.getMemail() ) // 찾은 사용자 정보의 아이디
                .password( memberEntity.getMpassword() ) // 찾은 사용자 정보의 패스워드
                .authorities( memberEntity.getMrole() ).build(); // 찾은 사용자 정보의 권한

        return userDetails;
    }

    // Controller -> Service -> Repository
    // Controller <- Service <- Repository
    @Autowired
    private MemberEntityRepository memberEntityRepository;

    @Autowired
    private HttpServletRequest request;

    // [C] 회원가입
    @Transactional // 트랜젝션 : 여러개 SQL을 하나의 최소 단위[ 성공,실패 ]
    public boolean postMember( MemberDto memberDto ){

        //--------------------------------------------------------------
        // 암호화
        // 입력받은 비밀번호 [ memberDto.getMpassword() ] 를 암호화해서 다시 memberDto 에 저장
        memberDto.setMpassword( passwordEncoder.encode( memberDto.getMpassword() ) );
        // memberDto.getMpassword() -> passwordEncoder.encode() -> memberDto.setMpassword()
        //--------------------------------------------------------------


        // 1. dto -> entity 변경후 repository 통한 insert 후 결과 entity 받기
        MemberEntity memberEntity =
                        memberEntityRepository.save( memberDto.toEntity() );
        // 2. insert 된 엔티티 확인후 성공/ 실패 유뮤
            // 3. 만약에 회원번호가 0 보다 크면 (auto_increment 적용됨)
        if( memberEntity.getMno() >= 1){
            return true;
        }
        System.out.println("memberDto = " + memberDto);
        return false;
    }


    // [R]  회원정보 호출
   /* @Transactional
    public MemberDto getMember( int mno){
        
        // 1. mno[회원번호pk] 를 이용한 회원 엔티티 찾기
        Optional<MemberEntity> optionalMemberEntity =
                                        memberEntityRepository.findById( mno );
        // 2. optional 클래스로 검색한 반환값 확인
        if( optionalMemberEntity.isPresent()){ // 3. 만약에 optional 클래스 안에 엔티티가 들어있으면

            // 4. optional 클래스에서 엔티티 꺼내기
            MemberEntity memberEntity = optionalMemberEntity.get();
            // 5. entity -> dto 변환후 반환
            return memberEntity.toDto();
        }
        System.out.println("mno = " + mno);
        return null;
    }*/

   /* // 2.  R 회원정보 호출 [1명] 세션 썼을때
    @Transactional
    public MemberDto getMember ( ){
        // 1. 세션 호출
        Object session = request.getSession().getAttribute("mno");
        // 2. 세션 검증
        if(session != null){
            return (MemberDto) session;
        }
        return null;
    }*/



    // [U]  회원정보 수정
    @Transactional
    public boolean updateMember( MemberDto memberDto){
        // 1. 수정할 엔티티 찾기 [mno]
        Optional<MemberEntity> optionalMemberEntity =
                                memberEntityRepository.findById( memberDto.getMno() );
        // 2. optional 클래스로 검색한 반환값 찾기
        if(optionalMemberEntity.isPresent()){

            // 3. 엔티티 꺼내기
            MemberEntity memberEntity = optionalMemberEntity.get();
            // 4. 엔티티 수정 [ 엔티티 객체를 수정하면 엔티티는 테이블과 매핑된 상태 이므로 db 의 정보도 같이 수정 ]
            memberEntity.setMname( memberDto.getMname() );
            memberEntity.setMpassword( memberDto.getMpassword() );
            memberEntity.setMphone( memberDto.getMphone());
            // 5. 성공시
            //logout();
            return true;
        }
        System.out.println("memberDto = " + memberDto);
        return false;
    }

    // [D] 회원탈퇴
    @Transactional
    public boolean deleteMember( int mno ){

        // 1. 삭제할 엔티티 찾기
        Optional<MemberEntity> optionalMemberEntity =
                    memberEntityRepository.findById( mno );
        // 2. 만약에 삭제할 엔티티가 반환/검색 존재하면
        if( optionalMemberEntity.isPresent()){
            memberEntityRepository.deleteById( mno ); // 3. 엔티티 삭제
            //4. 삭제 성공시
            // 로그아웃 함수 재사용
            //logout( );
            return true;
        }

        memberEntityRepository.deleteById(mno);
        System.out.println("mno = " + mno);
        return false;
    }

    public String getId( String mname , String mpassword ){

        Optional<MemberEntity> optionalString =
                        memberEntityRepository.findByMnameAndMpassword( mname, mpassword );

        if( optionalString.isPresent()){

            MemberEntity memberEntity = optionalString.get();

            String memail = memberEntity.getMemail();

            return memail;
        }
        return null;
    }


    public String getpassWord( String memail , String mphone ){

        Optional<MemberEntity> optionalString =
                memberEntityRepository.findByMemailAndMphone( memail, mphone );

        if( optionalString.isPresent()){

            MemberEntity memberEntity = optionalString.get();

            String mpassword = memberEntity.getMpassword();

            return mpassword;

        }

        return null;
    }


    //로그인 안했고 상태 저장하는곳 => request 객체도 스프링 컨테이너 등록


    @Transactional
    public boolean login( MemberDto memberDto ) {

        // 1. 입력받은 데이터 [아이디 , 패스워드 ] 검증하기
        List<MemberEntity> memberEntites = memberEntityRepository.findAll();
            //2. 동일한 아이디 / 비밀번호 찾기
            for ( int i = 0; i < memberEntites.size(); i++) {
                MemberEntity m = memberEntites.get(i);
                // 3. 동일한 데이터 찾았다
                if(m.getMemail().equals( memberDto.getMemail() ) &&
                                    m.getMpassword().equals( memberDto.getMpassword())){
                    // 4. 세션 부여         // 세션 저장
                    request.getSession().setAttribute("mno", m.toDto());
                    return true;
                }
            }
        return false;
    }

    /*// 6.
    public boolean logout(){
        request.getSession().setAttribute("mno", null);
        return true;
    }*/

    // 7.

        public boolean getFindMemail( String memail ){

        // 1. 이메일을 이용한 엔티티 찾기
        boolean result = memberEntityRepository.existsByMemail(memail);
        if(result){
            return true;
        }
        return false;
    }

    // 내가 한거
    /*
    @Autowired
    private HttpSession session;

    public boolean login( MemberDto memberDto ) {

        Optional<MemberEntity> optional =
                memberEntityRepository.findByMemailAndMpassword(memberDto.getMemail(), memberDto.getMpassword());

        if (optional.isPresent()) {

            MemberEntity memberEntity = optional.get();

            int mno = memberEntity.getMno();

            if (mno > 0) {
                MemberDto member = getMember(mno);
                session.setAttribute("loginDto", member);

                MemberDto dto = (MemberDto) session.getAttribute("loginDto");
                System.out.println("로그인 정보" + dto);

                return true;
            }

            else if( mno == 0 ){
                return false;
            }
        }
        return false;
    }

    public boolean logout( int mno ){

        int loginmno = ((MemberDto)session.getAttribute("loginDto")).getMno();
        if( mno == loginmno ){
            session.setAttribute("loginDto", null);
            return true;

        }
        else {
            return false;
        }

    }*/



}
