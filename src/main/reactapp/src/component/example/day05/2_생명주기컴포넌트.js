
import { useState , useEffect } from'react';

export default function 생명주기컴포넌트() {

    // 1. useState 함수를 이용한 초기갑 0 으로 하는 [ 변수 , 수정함수 ] 리턴받음
    let [ value , setValue ] = useState( 0 );

    const valueUpdate = (e) => { value++; setValue( value ); }

    let [ value2, setValue2 ] = useState( 0 );
    const value2Update = (e) => { value2++; setValue2( value2 ); }

    // 2. 컴포넌트 생명주기 1.탄생 / 2.업데이트 / 3.제거 할 때 실행되는 함수

        // 1. 컴포넌트 탄생 / 업데이트    <= 컴포넌트가 첫 실행과 업데이트 할 떄 실행되는 함수
        // useEffect( 함수 )
    useEffect( () => { console.log('[1]Effect 실행') });

        // 2. 컴포넌트 탄생 <= 컴포넌트가 첫 실행 될 때만 실행되는 함수
        // useEffect( 함수 ,[] )
    useEffect( () => { console.log('[2]Effect 실행') } ,[] );

        // 3. 컴포넌트 탄생 / 업데이트
        // useEffect( 함수 , [의존성배열] )
    useEffect( () => { console.log('[3]Effect 실행') },[ value ] );



    return(<>
        <div>{value}</div>
        <button onClick={ valueUpdate }>+</button>

         <div>{value2}</div>
         <button onClick={ value2Update }>+</button>
    </>)

}

/*
    컴포넌트의 생명주기
        탄생 [ Mounting ]-----------> 업데이트[updating] ------------> 제거 [ unMount ]
        1. 함수/컴포넌트 생성
                |                    1. setState() : 상태 변경 되었을떄
        2. 함수/컴포넌트 호출           2. forceUpdate : 강제 렌더링
            <컴포넌트명/>              3. new props : props 가 변경 되었을때
                |                           |
                |                           |
        3.                   가상 DOM UPDATE / root.reder( )
                |                           |
                |                           |
                |                           |
           컴포넌트 탄생                  컴포넌트 업데이트                컴포넌트 업데이트

        useEffect( () =>{} )
        useEffect( () =>{} , [] )
        useEffect( () =>{} , [useState 변수명] )
    useEffect : 컴포넌트의

*/