let template=`
<div>
   <table>
        <tr>
            <th>번호</th>
            <td>{{boardInfo.no}}</td>
        </tr>
        <tr>
            <th>작성일</th>
            <td>{{boardInfo.createdDate }}</td>
        </tr>
        <tr>
            <th>이름</th>
            <td>{{boardInfo.writer}}</td>

        </tr>
        <tr>
            <th>제목</th>
            <td>{{boardInfo.title}}</td>

        </tr>
        <hr>
        <tr>
            <td>
                <textarea v-model="boardInfo.content" cols="100" rows="10" readonly/>
            </td>
        </tr>
        <tr>
            <button type="button" @click="goToUpdateForm()"> 수정 </button>
        </tr>
   </table>
</div>
`;

export default{
    template,
    data(){
        return{
            boardInfo:{}
        }
    },
    created(){
        let no = this.$route.query.no
        this.getBoardInfo(no);
    },
    methods :{
        async getBoardInfo(no){
            this.boardInfo = await fetch('http://localhost:8099/boards/'+no)
                                .then(res => res.json())
                                .catch(err=> console.log(err));
        },
        goToUpdateForm(){
            this.$router.push({name : 'boardUpdate',
                                query : { no : this.boardInfo.no }})
        }
    }
}