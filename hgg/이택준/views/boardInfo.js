//boardInfo.js
let template = `
<div>
    <table>
        <tr>
            <th>번호</th><td align="center">{{boardInfo.no}}</td>
            <th>작성일</th><td align="center">{{boardInfo.createdDate}}</td>
            <th>이름</th><td align="center">{{boardInfo.writer}}</td>
        </tr>
        <tr>
            <th>제목</th><td colspan="4">{{boardInfo.title}}</td>
        </tr>
        <tr>
            <td colspan="5">{{boardInfo.content}}</td>
        </tr>
        <tr align="center">
            <button type="button" @click="goToUpdateForm()">수정</button>
        </tr>
    </table>
</div>
`;

export default{
    template,
    data(){
        return{
            boardInfo : {}
        }
    },
    created(){
        let no = this.$route.query.no;
        this.getBoardInfo(no);
    },
    methods : {
        async getBoardInfo(no){
            this.boardInfo = await fetch('http://localhost:8099/boards/'+no)
                                  .then(res => res.json())
                                  .catch(err => console.log(err))
        },
        goToUpdateForm(){
            this.$router.push({ name : 'boardUpdate',
                                query : { no : this.boardInfo.no}})
        }
    }

}