// updateBoard.js

let template = `
<div>
    <h3>번호</h3>
    <td><input type="text" v-model="board.no"></td>
    <h3>이름</h3>
    <td><input type="text" v-model="board.writer"></td>
    <h3>제목</h3>
    <td><input type="text" v-model="board.title"></td>
    <h3>내용</h3>
    <textarea v-model="board.content"/></td>
    <h3>작성일</h3>
    <td><input type="text" v-model="board.createdDate"></td>
    <button type="button" @click="updateBoardInfo()">수정</button>
</div>
`;

export default{
    template,
    data(){
        return{
            board: {
                no: '',
                title: '',
                writer: '',
                content: '',
                createdDate: new Date()
            }
        }
    },
    created(){
        let no = this.$route.query.no;
        this.getBoardInfo(no);
    },
    methods: {
        updateBoardInfo(){
            let data = {
                no: this.board.no,
                title: this.board.title,
                writer: this.board.writer,
                content: this.board.content,
                createDate: this.board.createdDate
            }
            fetch('http://localhost:8099/boards/'+data.no, {
                method: 'put',
                headers: {
                    'content-type': 'application/json'
                },
                body: JSON.stringify(data)
            })
            .then(res => res.json())
            .then(data => {
                if(data != null){
                    alert('정상적으로 수정');
                    this.board.no = data.no;
                }
                else{
                    alert('수정 오류')
                }
            })
            .catch(err => console.log(err));
        },
        async getBoardInfo(no){
            this.board = await fetch('http://localhost:8099/boards/'+no)
                                    .then(res => res.json())
                                    .catch(err => console.log(err));
        }
    }
}