// boardList.js

let template = `
<div>
  <table :class="[myTable, myText]">
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
      <tr v-for="board in boardList" :key="board.no" @click="goToBoard(board.no)">
        <td>{{ board.no }}</td>
        <td>{{ board.title }}</td>
        <td>{{ board.writer }}</td>
        <td>{{ board.createdDate }}</td>
        <td>{{ board.comment }}</td>
      </tr>
    </tbody>
  </table>
</div>
`;

export default {
    template,
    data() {
        return {
            boardList : [],
            myTable : 'table table-bordered',
            myText : 'text-center'
        }
    },
    created() {
        this.getboardList(); // 비동기.
    },
    methods : {
        async getboardList() {
            this.boardList = await fetch('http://localhost:8099/boards')
                                  .then(res => res.json())
                                  .catch(err => console.error(err));
        },
        goToBoard(boardNo) {
            this.$router.push({ name : 'board',
                                query : { id : boardNo } });
        }
    }
}