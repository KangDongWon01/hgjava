// boardInfo.js

let template = `
    <div>
        <table>
            <tr>
                <th>번호</th>
                <td> {{boardInfo.no}}</td>
            </tr>
            <tr>
                <th>작성일</th>
                <td> {{boardInfo.createdDate}}</td>
            </tr>
            <tr>
                <th>이름</th>
                <td> {{boardInfo.writer}} </td>      
            </tr>
            <tr>
                <th>제목</th>
                <td> {{boardInfo.title}}</td>
            </tr>
             <tr>
                <th>content</th>
                <td>
                    <textarea  readonly> {{boardInfo.content}} </textarea>
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
    data(){
        return {
            boardInfo : {}
        }
    },
    created(){
        let id = this.$route.query.id; // 받는쪽에서 나는 쿼리를 이용해서 id로 받겠습니다.  내가 가진 라우'트' 정보.쿼리. ; 라우터를 통해 만들어진 컴포넌트는 내부에 라우트를 가지고있고 속성에 라우트한테 푸시한정보가 같이 있다. 
        this.getBoardInfo(id);
    },
    methods : {
       async getBoardInfo(id){
            this.boardInfo = await fetch('http://localhost:8099/boards/'+ id)
            .then(res => res.json())
            .catch(err => console.log(err));
        },
        goToUpdateForm(){ 
            this.$router.push({ name : 'boardForm', 
                               query : { id : this.boardInfo.no } 
        }) 
        }
    }
}

// this.boardInfo.craeteDate
// = this.dateFormat(this.boardinfo.createdDate)