// boardInfo.js

let template = `
<div>
    <h3>번호</h3>
    <td>{{boardInfo.no}}</td>
    <h3>이름</h3>
    <td>{{boardInfo.writer}}</td>
    <h3>제목</h3>
    <td>{{boardInfo.title}}</td>
    <h3>내용</h3>
    <td><textarea readonly>{{boardInfo.content}}</textarea></td>
    <h3>작성일</h3>
    <td>{{boardInfo.createdDate}}</td>
    <button type="button" @click="goToUpdateForm()">수정</button>
</div>
`;

export default{
    template,
    data(){
        return{
            boardInfo: {}
        }
    },
    created(){
        let no = this.$route.query.no;
        this.getBoardInfo(no);
    },
    methods: {
        async getBoardInfo(no){
            this.boardInfo = await fetch('http://localhost:8099/boards/'+no)
                                    .then(res => res.json())
                                    .catch(err => console.log(err));
        },
        goToUpdateForm(){
            this.$router.push({name: 'postForm', query: {no: this.boardInfo.no}});
        }
    }
}