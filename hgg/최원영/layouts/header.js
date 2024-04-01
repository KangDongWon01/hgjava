// header.js

let template = `
<header>
    <h1>게시판</h1>
    <router-link v-bind:to="{name: 'home'}">home</router-link>
    |
    <router-link v-bind:to="{name: 'boardList'}">전체조회</router-link>
    |
    <router-link v-bind:to="{name: 'insertBoard'}">글등록</router-link>
</header>
`;

export default{
    template,
    name: 'headerComponent'
}