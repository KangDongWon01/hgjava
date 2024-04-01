//board.js
import CommentComponent from "../components/comment.js";
let template =` 
<div>
    <table>
        <thead>
        <tr>
            <th>번호</th>
            <td>{{boardInfo.no}}</td>
            <th>작성일</th>
            <td>{{getDate(boardInfo.createdDate)}}</td>
            <th>이름</th>
            <td>{{boardInfo.writer}}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>{{boardInfo.title}}</td>
        </tr>
        </thead>
        <tbody>
        <tr>
        <th/>
            <td>{{boardInfo.content}}</td>
        </tr>
        </tbody>
        <tr>
        <th/>
            <td><button type="button" @click="goToUpdateForm()">수정</button></td>
        </tr>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>댓글 목록</th>
                    </tr>
                </thead>
                <tbody>
                    <td>
                    <CommentComponent/>
                    </td>
                </tbody>
            </table>
        </div>
    </table>
</div>
`;

export default{
    template,
    data(){
       return {
        boardInfo : {}
       }
   },
   created(){
    let no = this.$route.query.no;
    this.getBoardInfo(no);
   },
   methods:{
    async getBoardInfo(no){
        this.boardInfo = await fetch('http://localhost:8099/boards/'+no)
                                .then(res=>res.json())
                                .catch(err=>console.log(err))
    },
    goToUpdateForm(){
        this.$router.push({name : 'boardForm',	
                            query : { no : this.boardInfo.no}})
    },
    getDate(date){
        return new Date(date).toLocaleDateString().replace(/\./g, '').replace(/\s/g, '-') 
    }
   },
   components:{
    CommentComponent
   }

}