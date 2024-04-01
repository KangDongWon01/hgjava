// header.js

let template = `
<header>
    <nav class="nav">
        게시판 &ensp;&ensp;&ensp;&ensp;
        <router-link :to="{ name : 'home' }"> Home </router-link> &ensp;
        <router-link :to="{ name : 'boardList' }"> 전체조회 </router-link> &ensp;
        <router-link :to="{ name : 'boardForm' }"> 글 등록 </router-link> &ensp;
    </nav>
</header>
`;

export default {
    template,
    name : 'headerComponent'
}