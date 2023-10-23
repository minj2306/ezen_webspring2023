/*
    Index : 여러 컴포넌트들을 연결하는 최상위 컴포넌트
        - 가상 URL 정의해서 컴포넌트를 연결하는 공간
*/
import {BrowserRouter , Routes , Route , Link}
    from 'react-router-dom';
import Header from './Header';
import Main from './Main';
import Footer from './Footer';

import ExampleList from './example/ExampleList';

import TodoList from './example/day02/TodoComponentList'
import 과제1 from './example/day01/과제1_도서목록'
import Login from './member/Login';
import Signup from './member/Signup';

import 컴포넌트1 from './example/day01/1_컴포넌트'
import 컴포넌트2 from './example/day01/2_컴포넌트'
import 컴포넌트명 from './example/day01/3_컴포넌트'
import 컴포넌트4 from './example/day01/4_컴포넌트'

import CSS컴포넌트 from './example/day02/1_CSS적용컴포넌트'
import CommentList from './example/day02/CommentList'

export default function Index( props ){

    return(<>
        <div className="webContainer">
            <BrowserRouter>
                <Header />
                <Routes>
                    {/*MAIN*/}
                    <Route path='/' element ={ <Main/> }/>
                    {/*EXAMPLE*/}
                    <Route path='/example' element ={ <ExampleList/> }/>
                    <Route path='/example/day01/컴포넌트1' element ={ <컴포넌트1/> }/>
                    <Route path='/example/day01/컴포넌트2' element ={ <컴포넌트2/> }/>
                    <Route path='/example/day01/컴포넌트명' element ={ <컴포넌트명/> }/>
                    <Route path='/example/day01/컴포넌트4' element ={ <컴포넌트4/> }/>
                    <Route path='/example/day02/CSS적용컴포넌트' element ={ <CSS컴포넌트/> }/>
                    <Route path='/example/day02/ComponentList' element ={ <CommentList/> }/>
                    {/*도서목록*/}
                    <Route path='/assignment' element ={ <과제1/> }/>
                    {/*TODO*/}
                    <Route path='/todocomponent' element ={ <TodoList/> }/>
                    {/*MEMBER*/}
                    <Route path='/signup' element ={ <Signup/> }/>
                    <Route path='/login' element ={ <Login/> }/>

                </Routes>
                <Footer />
            </BrowserRouter>
        </div>
           </>)
}