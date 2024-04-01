//postInfo.js
let template=`
<div>
<table>
    <tr>
      <th>번호</th>
      <td>{{postInfo.no}}</td>
      <th>작성일</th>
      <td>{{postInfo.createdDate}}</td>
      <th>이름</th>
      <td>{{postInfo.writer}}</td>
    </tr>
   <tr>
      <th>제목</th>
      <td>{{postInfo.title}}</td>
    </tr>
    <tr>
      <td>{{postInfo.content}}</td>
    </tr>
    <tr>
      <button type ="button" @click="goToUpdateForm()">수정</button>
    </tr>
   
</table>
</div>
`;

export default{
    template,
    data(){
        return{
            postInfo:{}
        }
    },
    created(){
        let id = this.$route.query.id
        console.log(id);
        this.getPostInfo(id)
    },
    methods:{
        async getPostInfo(id){
            this.postInfo = await fetch('http://localhost:8099/boards/'+id)
            .then(res => res.json())
            .catch(err => console.log(err))
        },
        goToUpdateForm(){
            this.$router.push({name:'postUpdate',
                            query:{id: this.postInfo.no}})
          }
    }
}
