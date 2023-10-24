
import { Link } from 'react-router-dom';


export default function ExampleList( props ){
    return(<>
        <div
            style = {{ display:'flex' , justifyContent:'space-between'}}>
            <Link to='/example/day01/컴포넌트1'>컴포넌트1 예제</Link>
            <Link to='/example/day01/컴포넌트2'>컴포넌트2 예제</Link>
            <Link to='/example/day01/컴포넌트명'>컴포넌트3 예제</Link>
            <Link to='/example/day01/컴포넌트4'>컴포넌트4 예제</Link>
            <Link to='/example/day02/CSS적용컴포넌트'>CSS컴포넌트 예제</Link>
            <Link to='/example/day02/ComponentList'>ComponentList 예제</Link>
            <Link to='/assignment'>과제1</Link>
            <Link to='/todocomponent'>과제2</Link>
            <Link to='/example/day04/Axios컴포넌트'>Axios컴포넌트</Link>

        </div>
    </>)
}