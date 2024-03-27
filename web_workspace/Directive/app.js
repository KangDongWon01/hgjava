//app.js
// => Root Commponent
//자식 컴포넌트 임포트 > 독립되어 있어서 하나의 파일에 담겨있음.
import RawComponent from './raw.js'; //js는 같은 폴더라도 이렇게 경로표시함.
import InputComponent from './input.js';
import ExamComponent from './exam01.js';
import ListComponent from './list.js';
import ForComponent from './exam02.js';
import IfComponent from './if.js';

const { createApp } = Vue

//해당 위치에 컴포넌트 지정. 카멜/케밥표기법 적용
const template = `
<div>
    <!-- 자식 컴포넌트 추가 -->
    <!-- <RawComponent/> -->
    <!-- <InputComponent/> -->
    <!-- <ExamComponent/> -->
    <!-- <ListComponent/> -->
    <!-- <ForComponent> -->
    <IfComponent>
</div>
`;

// Root 컴포넌트의 구성에 대한 표기
createApp({
    template,
    components : {
        RawComponent, // 'raw-component' : RawComponent >> 이름지정 >> vue가 자동으로 케밥표기법을 카멜표기법으로 바꿈
        InputComponent,
        ExamComponent,
        ListComponent,
        ForComponent,
        IfComponent
    }
})
.mount('#app');