//boardInsert.js

let template =`
<div>
<table>
    <thead>
            <tr>
                <th>No.</th>
                <td><input type="text" v-model="board.no" readonly></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" v-model="board.title"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" v-model="board.writer"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea v-model="board.content" />
                </td>
            </tr>
            <tr>
                <th>작성일자</th>
                <td><input type="text" v-model="board.createdDate"></td>
            </tr>
            <tr>
                <button type="button" @click="createBoardInfo()"> 저장 </button>
            </tr>
        </thead>
    </table>
</div>
`;


export default{
    template,
    data(){
        return{
            board : {
                no : '',
                title : '',
                writer : '',
                content : '',
                createdDate : '',
            }
        }
    },
    methods : {
        createBoardInfo(){
            let data = {
                title : this.board.title,
                writer : this.board.writer,
                content : this.board.content,
                createDate :this.board.createdDate,              
            }
            fetch('http://localhost:8099/boards', {
                method : 'post',
                headers : {
                    'content-type' : 'application/json' 
                },
                body : JSON.stringify(data) 
            })
            .then(res=> res.json())
            .then(data =>{
                console.log(data);
                if(data != null){
                    alert('정상적으로 등록되었습니다.')
                    this.board.no = data.no;
                }else{
                    alert('등록되지 않았습니다.\n데이터를 확인해주세요.')
                }
            })
            .catch(err=>console.log(err))
        },


    }

}