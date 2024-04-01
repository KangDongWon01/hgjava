//header.js

let template=`
<div>
    <router-link to="/home">HOME</router-link>
    <router-link v-bind:to="{name : 'home'}">Home</router-link>
    <br>
    <router-link v-bind:to="{path : '/postList'}">전체조회</router-link>
    <br>
    <router-link v-bind:to="{path : '/postForm'}">등록</router-link>
</div>
`;

export default{
    template,
    name : 'header'
}