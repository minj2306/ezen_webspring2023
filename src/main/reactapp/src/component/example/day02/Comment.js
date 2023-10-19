
// 사진 호출하기 : import 사진명 from '사진경로';
import logo from '../../../logo.svg';
// css 파일 호출하기 : import style from 'css파일경로';
import style from './component.css';

export default function Comment(props) {

    return (<>
        <div className="wrap">
            <div>
                <img src={logo} className="pimg"/>{/*작성자 프로필*/}
            </div>
            <div className="commentBox">
                <div className="commentName">
                    {props.name}
                </div>{/*작성자 이름*/}
                    {props.content}
                <div className="commentContent">

                </div>{/*게시물 내용*/}
            </div>
        </div>

    </>)
}