// postForm.js 컴포넌트 활용성 기능합치기 insert템플릿가져옴.

let template=`
<div>
<table>
    <tr>
        <th>No.</th>
        <td><input type ="text" v-model="board.no" readonly></td>
    </tr>
    <tr>
        <th>제목</th>
        <td><input type ="text" v-model="board.title"></td>
    </tr>
    <tr>
        <th>이름</th>
        <td><input type ="text" v-model="board.writer"></td>
    </tr>
     <tr>
        <th>내용</th>
        <td>
            <textarea v-model="board.content"></textarea>
        </td>
    </tr>
    <tr>
    <th>작성일자</th>
        <td><input type ="text" v-model="board.updatedDate"></td>
    </tr>
    <tr>
        <button type="button" @click="isUpdated? updateBoardInfo() : createBoardInfo()">저장</button>
    </tr>
</table>
</div>   
`;

export default {
    template,
    data(){
        return{
            board : { 
                no : '',
                title : '',
                writer : '',
                content : '',
                updatedDate : ''
            },
            isUpdated : false  
        }
    },
    created(){
        let id = this.$route.query.id; 
        if(id > 0) {
            this.getBoardInfo(id); 
            this.isUpdated = true;
        } 
    },
    methods : {
        async getBoardInfo(id){
            this.board = await fetch('http://localhost:8099/boards/'+id)
            .then(res => res.json())
            .catch(err => console.log(err));
        }, 
        createBoardInfo(){ 
            let data = {
                title : this.board.title,
                writer : this.board.writer,
                content : this.board.body,
                updatedDate : this.board.updatedDate
            }
        fetch('http://localhost:8099/boards/',{  
            method : 'post',
            headers : {
                'content-type' : 'application/json'
                },
                body : JSON.stringify(data) 
         })
        .then(res=> res.json())
        .then(data =>{
               console.log(data);
            if(data != null) {
                alert('정상적으로 저장되었습니다.')
                this.board.id = data.id;
            } else {
                alert('저장되지않았습니다.\n 데이터확인해주세요')
            }
        })
        .catch(err=> console.log(err))
        },
        updateBoardInfo(){ 
           let data = {
                no : this.board.no,
                title : this.board.title,
                writer : this.board.writer,
                content : this.board.content,
                createdDate : this.board.updatedDate
            } 
        fetch('http://localhost:8099/boards/'+ data.id, {  
            method : 'put',
            headers : {
                    'content-type' : 'application/json'
            },
            body : JSON.stringify(data) 
        })
        .then(res=> res.json())
        .then(data => {
                console.log(data);
                if(data != null) {
                    alert('정상적으로 수정되었습니다.')
                } else {
                    alert('수정되지않았습니다.')
                }
        })
        .catch(err=> console.log(err))
        }  
        }
    }