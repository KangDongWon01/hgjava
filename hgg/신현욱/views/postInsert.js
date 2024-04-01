let template=`
<div>
<table>
    <tr>
      <th>No</th>
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
      <td>
        <td><textarea v-model="post.content"/></td>
      </td>
    </tr>
    <tr>
      <th>작성일자</th>
      <td><input type="text" v-model="post.createdDate" readonly></td>
    </tr>
    <tr>
       <button type="button" @click="createPostInfo()">저장</button>
    </tr>
</table>
</div>
`
const date = new Date();
const year = date.getFullYear();
const month = date.getMonth() + 1; 
const day = date.getDate();	
const formatDate1 = year+'-'+month+'-'+day; 
export default{
    template,
    data(){
        return{
            post : {
                no:'',
                title:'',
                writer:'',
                content:'',
                createdDate:formatDate1
            }
        }
    },
    methods : {
        createPostInfo(){
            let data={
                no: this.post.no,
                title: this.post.title,
                writer: this.post.writer,
                content: this.post.content,
                createdDate: this.post.createdDate
            }
            fetch('http://localhost:8099/boards',{
                method:'post',
                headers : {
                    'content-type' : 'application/json'
                },
                body : JSON.stringify(data)
            })
            .then(res => res.json())
            .then(data => {
                if(data !=null){
                    alert('정상적으로 저장되엇습니다.')
                    this.post.no = data.no
                }else{
                    alert('저장되지 않음')
                }
                this.post.no = data.no
            })
            .catch(err => console.log(err));
        }
    }
}