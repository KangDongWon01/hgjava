//boardList.js

let template=`
<div>
    <table>
        <thead>
            <tr>
                <th>No.</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일자</th>
                <th>댓글수</th>
            </tr>
        </thead>
        <tbody>
        <template v-for="post in boardList" :key="post.no">
        <tr @click="goToDetail(post.no)">
            <td>{{post.no}}</td>
            <td>{{post.title}}</td>
            <td>{{post.writer}}</td>
            <td>{{getDate(post.createdDate)}}</td>
            <td>{{post.comment}}</td>
        </tr>
        </template>
    </tbody>
    </table>
</div>
`;
export default{
    template,
    data(){
       return {
        boardList : []
       }
   },
   created(){
    this.getBoardList();
   
   },
   methods : {
    async getBoardList(){
        this.boardList = await fetch('http://localhost:8099/boards')
                            .then(res=>res.json())
                            .catch(err=>console.log(err))
    },
    goToDetail(no){
        this.$router.push({ name : 'board', 
                                query:{ no : no } });
    },
    getDate(date){
        return new Date(date).toLocaleDateString().replace(/\./g, '').replace(/\s/g, '-') 
    }
   }

}