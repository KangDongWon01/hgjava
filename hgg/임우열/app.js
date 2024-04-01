import router from './router/router.js';

import HeaderComponent from './layout/header.js';
import FooterComponent from './layout/footer.js';

const { createApp } = Vue
    let template =`
    <div>
    <HeaderComponent/>
        <router-view :key="$route.fullPath"/>
    <FooterComponent/>
    </div>
    `;

    createApp({
        template,
        components: {
            HeaderComponent,
            FooterComponent
        }
    })
    .use(router)
    .mount('#app');