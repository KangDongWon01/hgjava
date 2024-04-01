// postUpdate.js

let template = `
<div>
    <table>
        <tr>
            <th>번호</th>
            <td><input type="text" v-model="board.no"></td>
        </tr>
        <tr>
            <th>작성일</th>
            <td><input type="text" v-model="board.createdDate"></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" v-model="board.writer"></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input type="text" v-model="board.title"></td>
        </tr>
        <tr>
            <th>제목</th>
            <td>
                <textarea>{{ board.content }}
                </textarea>
            </td>
        </tr>
        <tr>
          <button type="button" @click="goToUpdateForm()">수정</button>
        </tr>
    </table>
</div>

`;

export default {
  template,
  data() {
    return {
      board: {
        no: "",
        updatedDate: "",
        writer: "",
        title: "",
        content: "",
      },
    };
  },
  created() {
    let no = this.$route.query.no;
    this.getBoardInfo(no);
  },
  methods: {
    async getBoardInfo(no) {
      this.board = await fetch("http://localhost:8099/boards/"+no)
        .then((res) => res.json())
        .catch((err) => console.log(err));
    },
    UpdateBoardInfo() {
      let data = {
        no: this.board.no,
        updatedDate: this.board.updatedDate,
        writer: this.board.writer,
        title: this.board.title,
        content: this.board.content
      };
      fetch("http://localhost:8099/boards/"+data.no, {
        method: "put",
        headers: {
          "content-type": "application/json",
        },
        body: JSON.stringify(data),
      })
        .then((res) => res.json())
        .then((data) => {
          console.log(data);
          if (data != null) {
            alert("정상적으로 수정되었습니다");
            this.board.no = data.no;
          } else {
            alert("수정되지 않았습니다. \n 데이터를 확인해주세요");
          }
        })
        .catch((err) => console.log(err));
    },
  },
};
