//boardList.js


let template = `
<div>
<table>
    <thead>
        <tr>
            <th>No.</th>
            <th>title</th>
            <th>writer</th>
            <th>createdDate</th>
            <th>comment</th>
        </tr>
    </thead>
    <tbody>
        <template v-for="board in boardList" :key="board.no">
        <tr v-if ="board.no >= 0" 
            @click="goToDetail(board.no)"> 
            <td>{{board.no}} </td>
            <td>{{board.title}} </td>
            <td>{{board.writer}} </td>
            <td>{{board.createdDate | yyyyMMdd }} </td>
            <td>{{board.comment}} </td>
        </tr>
        </template>
    </tbody>
</table>
</div>
`;

export default {
    template,
    data() {
        return {
            boardList: []
        }
    },
    created() {
        this.getBoardList(); 
    },
    methods: {
        
        async getBoardList() { 
            this.boardList = await fetch('http://localhost:8099/boards')
                .then(res => res.json())
                .catch(err => console.log(err))
        },

        goToDetail(boardNo){
            this.$router.push({
                name : 'boardInfo',  
                query : {   
                         no : boardNo
                } 
            }); 
        }
    }
}
