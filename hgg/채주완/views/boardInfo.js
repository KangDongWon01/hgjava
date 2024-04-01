// postInfo.js

let template = `
<div>
    <table>
        <thead>
                <tr>
                    <th>번호</th>
                    <td>{{boardInfo.no}}</td>
                </tr>
                <tr>
                    <th>작성일</th>
                    <td>{{boardInfo.createdDate}}</td>
                </tr>
                <tr>
                 <tr>
                    <th>이름</th>
                    <td>{{boardInfo.writer}}</td>
                </tr>
                    <th>제목</th>
                    <td>{{boardInfo.title}}</td>
                </tr>
                <tr>
                    <td readonly>{{boardInfo.content}}</td>
                </tr>
                <tr>                                
                    <button type="button" @click="goToUpdateForm()">수정</button>
                </tr>
                </table>
                </thead>
                <hr>
            <tbody>
                <p>댓글 목록</p>
                
                <template v-for="comment in commentList" :key="comment.writer">
                    <p>{{comment.content}}</p>
                    <p>{{comment.writer}}</p>
                    <p>{{comment.createDate}}</p>
                </template>
            
        </tbody>
    </div>
`;

export default {
    template,
    data() {
        return{
            boardInfo: {},
            commentList: []
        }
    },
    created() {
        let no = this.$route.query.no;
        this.getBoardInfo(no);
        this.getCommentList();
        
    },
    methods: {
        async getCommentList(){
            this.commentList = await fetch('http://localhost:8099/comments')
            .then(res=> res.json())
            .catch(err=> console.log(err))
        },

        async getBoardInfo(no) {
            this.boardInfo = await fetch('http://localhost:8099/boards/' + no)
                .then(res => res.json())
                .catch(err => console.log(err))
        },
      

        goToUpdateForm(){
            this.$router.push({name : 'boardUpdate', 
                               query : {no : this.boardInfo.no}
            })
        },
    }
}
