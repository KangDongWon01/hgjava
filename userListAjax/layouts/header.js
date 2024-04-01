//header.js

let template=`
<div>
    <h1>MAIN</h1>
    <router-link v-bind:to="{ name : 'main' }">Main</router-link>
    <br>
    <router-link v-bind:to="{ path : '/userList' }">전체조회</router-link>
    <br>
    <router-link v-bind:to="{path : '/userInsert'}">등록</router-link>
</div>
`;

export default{
    template,
    name : 'header'
}