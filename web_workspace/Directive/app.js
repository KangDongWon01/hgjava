//app.js
// => Root Commponent
import RawComponent from './raw.js'; //js는 같은 폴더라도 이렇게 경로표시함.

const { createApp } = Vue

const template = `
<div>
    <!-- 자식 컴포넌트 추가 -->
    <RawComponent/>
</div>
`;

createApp({
    template,
    components : {
        RawComponent, // 'raw-component' : RawComponent
    }
})
.mount('#app');