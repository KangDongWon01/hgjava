//header.js

let template = `
<header>
    <h3>게시판</h3>
    <router-link v-bind:to="{ path : '/' }">Home</router-link>
    <router-link v-bind:to="{ path : '/boardList' }">전체조회</router-link>
    <router-link v-bind:to="{ path : '/boardForm' }">글 등록</router-link>
    <hr>
</header>
`;

export default{
    template,
    name : 'headerComponent'
}