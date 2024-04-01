//postInfo.js

let template = `
<div>
    <table>
        <tr>
            <th>id</th>
            <td>{{postInfo.id}}</td>
        </tr>
        <tr>
            <th>title</th>
            <td>{{postInfo.title}}</td>
        </tr>
        <tr>
            <th>userId</th>
            <td>{{postInfo.userId}}</td>
        </tr>
        <tr>
            <th>body</th>
            <textarea readonly>{{postInfo.body}}</textarea>
        </tr>
        <tr>
            <button type="button" @click="goToUpdateForm()">수정</button>
            <button type="button" @click="delPostInfo()">삭제</button>
        </tr>
    </table>
</div>
`;

export default {
    template,
    data(){
        return {
            postInfo : {}
        }
    },
    created(){
        let id = this.$route.query.id;
        this.getPostInfo(id);
    },
    methods : {
        async getPostInfo(id){
            this.postInfo = await fetch('https://jsonplaceholder.typicode.com/posts/'+id)
                            .then(res => res.json())
                            .catch(err => console.log(err));
        },
        goToUpdateForm(){
            this.$router.push({ name : 'postForm', query : { id : this.postInfo.id }})
        },
        delPostInfo(){
            fetch('https://jsonplaceholder.typicode.com/posts/'+this.postInfo.id, {
                method : 'delete' //get방식 X > delete방식
            })
            .then(res => res.json())
            .then(data => {
                let result = Object.keys(data).length;
                if( result == 0) {
                    alert('삭제 완료')
                } else {
                    alert('삭제 실패')
                }
            })
            .catch(err => console.log(err));
        }
    }
}