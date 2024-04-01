//BoardForm.js
let template = `
<div>
    <table>
        <tr>
            <th>No.</th>
            <td><input type = "text" v-model="board.no" readonly></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input type = "text" v-model="board.title"></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type = "text" v-model="board.writer"></td>
        </tr>
        <tr>
            <th>내용</th>
            <td>
            <textarea v-model="board.content"></textarea>
            </td>
        </tr>
        <tr>
        <th>작성일자</th>
        <td>
        <input type="text" v-model="board.createdDate" readonly>
        </td>
        </tr>
        <tr>
        <button type="button" @click="isUpdated ? updateBoardInfo() : createBoardInfo()">저장</button>
        </tr>
    </table>
</div>
`;

export default{
    template,
    data(){
       return {
        board :{
            no: 0,
            title: "",
            writer: "",
            content: "",
            createdDate:""
        },
        isUpdated : false
       }
   },
   created(){
    let no = this.$route.query.no;
    console.log(no)
    if(no>0){
        this.getBoardInfo(no);
        this.isUpdated = true;
    }
   }
   ,
   methods : {
        updateBoardInfo(){
            let data= {
                no : this.board.no,
                title: this.board.title,
                writer : this.board.writer,
                content : this.board.content,
                createdDate : this.board.createdDate
            }
            fetch('http://localhost:8099/boards/'+data.no,{
                method : 'put',
                headers : {
                    'content-type' : 'application/json'
                },
                body : JSON.stringify(data)
            })
            .then(res => res.json())
            .then(data=>{
                console.log(data);
                if(data !=null){
                    alert('정상적으로 수정되었습니다.');
                    this.board.no = data.no;
                }else{
                    alert('수정되지 않았습니다.\n데이터를 확인해주세요.')
                }
            })
        },
        async getBoardInfo(no){
            this.board = await fetch('http://localhost:8099/boards/'+no)
                                    .then(res=>res.json())
                                    .catch(err=>console.log(err));
        },
        createBoardInfo(){
            let data= {
                title: this.board.title,
                writer : this.board.writer,
                content : this.board.content
            }
            fetch('http://localhost:8099/boards',{
                method : 'post',
                headers : {
                    'content-type' : 'application/json'
                },
                body : JSON.stringify(data)
            })
            .then(res => res.json())
            .then(data=>{
                console.log(data);
                if(data !=null){
                    alert('정상적으로 저장되었습니다.');
                    this.post.no = data.no;
                }else{
                    alert('저장되지 않았습니다.\n데이터를 확인해주세요.')
                }
            })
        },
    getDate(date){
        return new Date(date).toLocaleDateString() 
    }

   }
}