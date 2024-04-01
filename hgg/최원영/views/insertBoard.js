// insertBoard.js

let template = `
<div>
    <h3>No.</h3>
    <input type="text" v-model="board.no" readonly>
    <h3>제목</h3>
    <input type="text" v-model="board.title">
    <h3>작성자</h3>
    <input type="text" v-model="board.writer">
    <h3>내용</h3>
    <textarea v-model="board.content"></textarea>
    <h3>작성일자</h3>
    <input type="text" v-model="board.createdDate" readonly>
    <br>
    <button type="button" @click="createBoardInfo()">저장</button>
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
    methods: {
        createBoardInfo(){
            let data = {
                title: this.board.title,
                writer: this.board.writer,
                content: this.board.content
            }
            fetch('http://localhost:8099/boards', {
                method: 'post',
                headers: {
                    'content-type': 'application/json',
                },
                body: JSON.stringify(data)
            })
            .then(res => res.json())
            .then(data => {
                if(data != null){
                    alert('정상적으로 등록');
                    this.board.no = data.no;
                }
                else{
                    alert('등록 오류');
                }
            })
            .catch(err => console.log(err));
        }
    }
}