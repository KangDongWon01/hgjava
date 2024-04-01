
let template =`
<header>
    <h3>게시판</h3>
    <router-link :to="{ path: '/home'}">Home</router-link><br>
    <router-link :to="{ name: 'boardList'}">전체조회</router-link>
    <router-link :to="{ name: 'boardInsert'}"> 등록 </router-link><br>
    

  
</header>
`;

export default{
    template,
    name:'header'
}