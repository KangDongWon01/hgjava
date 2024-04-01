//boardList.js
let template = `
<div>
    <table>
        <thead>
            <tr>
                <th>No.</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일자</th>
                <th>댓글 수</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="board in boardList" :key="board.no" @click="goToDetail(board.no)">
                <td>{{board.no}}</td>
                <td align="center">{{board.title}}</td>
                <td align="center">{{board.writer}}</td>
                <td align="center">{{board.createdDate}}</td>
                <td align="center">{{board.comment}}</td>
            </tr>
        </tbody>
    </table>
</div>
`;

export default{
    template,
    data(){
        return{
            boardList : []
        }
    },
    created(){
        this.getBoardList();
    },
    methods : {
        async getBoardList(){
            this.boardList = await fetch('http://localhost:8099/boards')
                                  .then(res => res.json())
                                  .catch(err => console.log(err));        
        },
        goToDetail(boardNo){
            this.$router.push({ name : 'boardInfo',
                                query : { no : boardNo} });
        }
    }
}