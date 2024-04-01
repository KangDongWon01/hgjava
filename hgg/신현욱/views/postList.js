
let template=`
<div>
<table>
    <thead>
       <tr>
          <th>no</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일자</th>
          <th>댓글수</th>
       </tr>
    </thead>
    <tbody>
    <template v-for="post in postList"  :key="post.id">
       <tr
          @click="goToDetail(post.no)">
          <td>{{post.no}}</td>
          <td>{{post.title}}</td>
          <td>{{post.writer}}</td>
          <td>{{post.createdDate}}</td>
          <td>{{post.comment}}</td>
       </tr>
       </template>
    </tbody>
</table>
</div>
`
export default{
    template,
    data(){
        return{
            postList: []
        }
    },
    created(){
        this.getPostList();
    },
    methods: {
        async getPostList(){
            this.postList = await fetch('http://localhost:8099/boards')
                                  .then(res => res.json())
                                  .catch(err => console.log(err))
            this.postList.created=this.dataFormat(this.postList.created);
        },
        goToDetail(postId){
            console.log(postId)
            this.$router.push({ name: 'postInfo',
                                query:{id : postId}})
        }
    }
}
