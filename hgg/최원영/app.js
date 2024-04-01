// app.js

import router from './router/router.js';

import HeaderComponent from './layouts/header.js';
import FooterComponent from './layouts/footer.js';

const {createApp} = Vue

let template = `
<div>
    <HeaderComponent/>
    <router-view :key="$route.fullPath" />
    <FooterComponent/>
</div>
`;

createApp({
    template,
    components: { // 헤더,푸터 >> 자식 컴포넌트 등록
        HeaderComponent,
        FooterComponent
    }
})
.use(router) // 라우터 >> 부모 컴포넌트 전역
.mount('#app');