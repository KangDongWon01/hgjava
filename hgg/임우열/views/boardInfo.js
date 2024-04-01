// boardInfo.js

let template = `
<div>
    <table>
        <tr>
            <th>번호</th>
            <td>{{ boardInfo.no }}</td>
        </tr>
        <tr>
            <th>작성일</th>
            <td>{{ boardInfo.createdDate }}</td>
        </tr>
        <tr>
            <th>이름</th>
            <td>{{ boardInfo.writer }}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>{{ boardInfo.title }}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>
                <textarea readonly>{{ boardInfo.content }}
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
      boardInfo: {},
    };
  },
  created() {
    let no = this.$route.query.no;
    this.getboardInfo(no);
  },
  methods: {
    async getboardInfo(no) {
      this.boardInfo = await fetch(
        "http://localhost:8099/boards/"+ no
      )
        .then((res) => res.json())
        .catch((err) => console.log(err));
        console.log(this.boardInfo);
    },
    goToUpdateForm() {
      this.$router.push({
        name: "boardUpdate",
        query: { no: this.boardInfo.no },
      });
    },
  },
};
