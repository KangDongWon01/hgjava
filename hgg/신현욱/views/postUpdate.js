let template=`
<div>
<table>
    <tr>
      <th>번호</th>
      <td><input type="text" v-model="post.no" readonly></td>
    </tr>
   <tr>
      <th>제목</th>
      <td><input type="text" v-model="post.title"></td>
    </tr>
    <tr>
      <th>작성자</th>
      <td><input type="text" v-model="post.writer"></td>
    </tr>
    <tr>
      <th>내용</th>
      <td><input type="text" v-model="post.content"></td>
    </tr>
    <tr>
    <th>작성일자</th>
      <td><input type="text" v-model="post.createdDate"></td>
    </tr>
    <tr>
      <button type ="button" @click="updatePostInfo()">저장</button>
    </tr>
   
</table>
</div>
`

export default{
    template,
    data(){
        return{
            post :{
                no:'',
                title:'',
                writer:'',
                content:'',
                createdDate:''
            }
        }
    },
    created(){
       let no = this.$route.query.id;
       this.getPostInfo(no)
    },
    methods :{
        async getPostInfo(no){
         this.post = await fetch('http://localhost:8099/boards/'+no)
                           .then(res => res.json())
                           .catch(err => console.log(err))
        },
        updatePostInfo(){
            let data={
                no: this.post.no,
                title: this.post.title,
                writer: this.post.writer,
                content: this.post.content,
                createdDate: this.post.createdDate
            }
            fetch('http://localhost:8099/boards/'+data.no,{
                method:'put',
                headers:{
                    'content-type' : 'application/json'
                },
                body : JSON.stringify(data)
            })
            .then(res => res.json())
            .then(data => {
                if(data != null){
                    alert('정상적으로 수정되었습니다.')
                    this.post.no = post.no
                }else{
                    alert('수정되지 않았습니다.')
                }
                this.post.no=data.no;
            })
            .catch(err => console.log(err));
        }
    }
}