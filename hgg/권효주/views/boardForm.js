// boardForm.js

let template = `
<div class="container mt-3">
    <form>
    <div :class="mySpacing">
        <label>No.</label>
        <input :class="myInput" type="text" v-model="board.no" readonly>
    </div>
    <div :class="mySpacing">
        <label>제목</label>
        <input :class="myInput" type="text" v-model="board.title">
    </div>
    <div :class="mySpacing">
        <label>작성자</label>
        <input :class="myInput" type="text" v-model="board.writer">
    </div>
    <div :class="mySpacing">
        <label>내용</label>
        <textarea :class="myInput" rows="5" v-model="board.content"></textarea>
    </div>
    <div :class="mySpacing">
        <label>작성일자</label>
        <input :class="myInput" rows="5" v-model="board.createdDate">
    </div>
    <button :class="myBtn" type="button" @click="isUpdated ? updateBoard() : createBoard()" >수정</button>
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
                updatedDate : ''
            },
            isUpdated : false,
            mySpacing : 'mb-3 mt-3',
            myInput : 'form-control',
            myBtn : 'btn btn-primary'
        }
    },
    created() {
        let id = this.$route.query.id;
        if(id > 0) { 
            this.getBoard(id);
            this.isUpdated = true;
        }
    },
    methods : {
        async getBoard(id) {
            this.board = await fetch('http://localhost:8099/boards/' + id)
                                  .then(res => res.json())
                                  .catch(err => console.error(err));
        },
        createBoard() {
            let now = new Date();
            let data = {
                title : this.board.title,
                writer : this.board.writer,
                content : this.board.content,
                createdDate : now
            }
            fetch('http://localhost:8099/boards',{
                method : 'POST',
                headers : {
                    'content-type' : 'application/json'
                },
                body : JSON.stringify(data)
            })
            .then(res => res.json())
            .then(result => {
                console.log(result);
                if(result != null){
                    alert('정상적으로 저장되었습니다.');
                    this.post.id = result.id;
                } else {
                    alert('저장되지 않았습니다.\n데이터를 확인해주세요');
                }
            })
            .catch(err => console.error(err));
        },
        updateBoard() {
            let data = {
                no : this.board.no,
                title : this.board.title,
                writer : this.board.writer,
                content : this.board.content,
                createdDate : this.board.createdDate
            }  
            fetch('http://localhost:8099/boards/' + data.no, {
                method : 'PUT',
                headers : {
                    'content-type' : 'application/json'
                },
                body : JSON.stringify(data)
            })
            .then(res => res.json())
            .then(result => {
                if(result != null){
                    alert('정상적으로 수정되었습니다.');
                } else {
                    alert('수정되지 않았습니다.\n데이터를 확인해주세요');
                }
            })
            .catch(err => console.error(err));
        }
    }
}

