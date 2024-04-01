// postForm.js

let template = `
<div>
    <table>
    <tr>
    <th>id</th>
    <td><input type="text" v-model="board.no" readonly></td>
</tr>
<tr>
    <th>title</th>
    <td><input type="text" v-model="board.title"></td>
</tr>
<tr>
    <th>userId</th>
    <td><input type="text" v-model="board.writer"></td>
</tr>
<tr>
    <th>body</th>
    <td>
        <textarea v-model="board.content" />
    </td>
</tr>
<tr>
    <th>작성일자</th>
    <td>{{ boardInfo.createdDate }}</td>
</tr>
        <tr>
            <button type="button" @click="isUpdated ? UpdatePostInfo() : createPostInfo()">저장</button>
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
        title: "",
        writer: "",
        content: "",
        createdDate: "",
      },
      isUpdated: false, // 보조 프로피티
    };
  },
  created() {
    let no = this.$route.query.no;
    if (no > 0) {
      this.getPostInfo(no);
      this.isUpdated = true;
    }
  },
  methods: {
    async getPostInfo(no) {
      this.board = await fetch(
        "http://localhost:8099/boards/" + no
      )
        .then((res) => res.json())
        .catch((err) => console.log(err));
    },
    createPostInfo() {
      let data = {
        no: this.board.no,
        body: this.board.body,
        writer: this.board.writer,
        content: this.board.content,
        createdDate: this.board.createdDate,
      };
      fetch("http://localhost:8099/boards", {
        method: "post",
        headers: {
          "content-type": "application/json",
        },
        body: JSON.stringify(data),
      })
        .then((res) => res.json())
        .then((data) => {
          console.log(data);
          if (data != null) {
            alert("정상적으로 저장되었습니다");
            this.board.no = data.no;
          } else {
            alert("저장되지 않았습니다. \n 데이터를 확인해주세요");
          }
        })
        .catch((err) => console.log(err));
    },
    UpdatePostInfo() {
        let data = {
            no: this.board.no,
            body: this.board.body,
            writer: this.board.writer,
            content: this.board.content,
            createdDate: this.board.createdDate,
          };
      fetch("http://localhost:8099/boards/" + data.no, {
        method: "PUT",
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
            this.post.no = data.no;
          } else {
            alert("수정되지 않았습니다. \n 데이터를 확인해주세요");
          }
        })
        .catch((err) => console.log(err));
    },
  },
};
