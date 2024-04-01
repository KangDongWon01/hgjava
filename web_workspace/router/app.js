import router from './router/router.js'

import HeaderComponent from './layouts/header.js'
import FooterComponent from './layouts/footer.js'


const { createApp } = Vue

let template = `
<div>
    <HeaderComponent/>
    <router-view :key="$route.fullPath" />
    <FooterComponent/>
</div>
`;
createApp({
    template,
    components : {
        HeaderComponent,
        FooterComponent
    }
})
.use(router) //라우터를 전역으로 쓰게 하는 메소드.
.mount('#app');
