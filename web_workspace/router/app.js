import router from './router/router.js'

const { createApp } = Vue

let template = `
<div>
    <router-link to="/home">HOME</router-link>
    <router-link v-bind:to="{name : 'home'}">Home</router-link>
    <br>
    <router-link v-bind:to="{path : '/postList'}">전체조회</router-link>
    <br>
    <router-link v-bind:to="{path : '/postInfo'}">단건조회</router-link>

    <router-view :key="$route.fullPath" />
</div>
`;
createApp({
    template,

})
.use(router) //라우터를 전역으로 쓰게 하는 메소드.
.mount('#app');
