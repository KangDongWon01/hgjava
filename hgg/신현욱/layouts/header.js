//header.js

let template=`
  <header>
  <router-link :to="{name:'home'}">Home</router-link>
  <router-link :to="{name:'postList'}">전체조회</router-link>
  ||<router-link :to="{name:'postInsert'}">글등록</router-link>
  </header>
`

export default{
    template,
    name: 'header'
}