//app.js
// => Root Commponent
import RawComponent from './raw.js'; //js는 같은 폴더라도 이렇게 경로표시함.
import InputComponent from './input.js';
import ExamComponent from './exam01.js';
import ListComponent from './list.js';
import ForComponent from './exam02.js';
import IfComponent from './if.js';

const { createApp } = Vue

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

createApp({
    template,
    components : {
        RawComponent, // 'raw-component' : RawComponent
        InputComponent,
        ExamComponent,
        ListComponent,
        ForComponent,
        IfComponent
    }
})
.mount('#app');