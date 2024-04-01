// board.js
import CommentComponent from '../components/comment.js';

let template = `
<div>
  <table :class="myTable">
    <thead>
      <tr>
        <th>번호</th>
        <td>{{ board.no }}</td>
        <th>작성일</th>
        <td>{{ board.createdDate }}</td>
        <th>이름</th>
        <td>{{ board.writer }}</td>
      </tr>
      <tr>
        <th colspan="2">제목</th>
        <td colspan="4">{{ board.title }}</td>
      </tr>
    </thead> 
    <tbody>
      <tr>
        <td colspan="6">{{ board.content }}</td>
      </tr>
      <tr>
        <button type="button" :class="myBtn" @click="goToUpdate(board.no)">수정</button>
      </tr>
    </tbody>
  </table>
  <div>
  </div>
</div>
`;

export default {
    template,
    data() {
        return {
            board : {
                no : '',
                title : '',
                writer : '',
                content : '',
                createdDate : '',
                comment : ''
            },
            bno : '',
            myTable : 'table table-bordered',
            myBtn : 'btn btn-primary',

        }
    },
    created() {
        let id = this.$route.query.id;
        this.getBoard(id);
    },
    methods : {
        async getBoard(id) {
            this.board = await fetch('http://localhost:8099/boards/' + id)
                                  .then(res => res.json())
                                  .then(ret => {
                                    this.bno = ret.no;
                                    return ret;
                                  })
                                  .catch(err => console.error(err));
        },
        goToUpdate(boardNo) {
          this.$router.push({ name : 'boardForm',
                              query : { id : boardNo } });
        }  
    },
    components : {
      CommentComponent
    }
}