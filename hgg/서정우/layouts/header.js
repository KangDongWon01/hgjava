//header.js

let template=`
<header>
<p>
<h1>게시판</h1>
    <router-Link v-bind:to="{path:'/home'}">Home</router-Link>
    || <router-Link v-bind:to="{path:'/boardList'}">전체조회</router-Link>
    || <router-Link v-bind:to="{path:'/boardForm'}">글 등록</router-Link>
    </p>
</header>
`;

export default{
    template,
    name : 'headerComp'
}