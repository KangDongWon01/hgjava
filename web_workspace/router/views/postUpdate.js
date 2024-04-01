//postUpdate.js

let template = `
<div>
    <table>
        <tr>
            <th>id</th>
            <td><input type="text" v-model="post.id" readonly></td>
        </tr>
        <tr>
            <th>title</th>
            <td><input type="text" v-model="post.title"></td>
        </tr>
        <tr>
            <th>userId</th>
            <td><input type="text" v-model="post.userId"></td>
        </tr>
        <tr>
            <th>body</th>
            <td><textarea v-model="post.body"/></td>
        </tr>
        <tr>
            <button type="button" @click="UpdatePostInfo()">수정</button>
        </tr>
    </table>
</div>
`;

export default{
    template,
    data() {
        return {
            post : {
                id : '', // 이 값이 오라클 DB로 가게 된다면 PK인 id가 공백이라 null취급. 오류남.
                title : '',
                body : '',
                userId : ''    
            }
        }
    },
    created() {
        let id = this.$route.query.id;
        this.getPostInfo(id);
    },
    methods : {
        async getPostInfo(id){
            this.post = await fetch('https://jsonplaceholder.typicode.com/posts/'+id)
                            .then(res => res.json())
                            .catch(err => console.log(err));
        },
        UpdatePostInfo() {
            let data = {
                id : this.post.id,
                title : this.post.title,
                body : this.post.body,
                userId : this.post.userId
            }

            fetch('https://jsonplaceholder.typicode.com/posts/'+data.id, {
                method : 'put',
                headers : {
                    'content-type' : 'application/json'
                },
                body : JSON.stringify(data)
            })
            .then(res => res.json())
            .then(data => {
                console.log(data);
                if(data != null){
                    alert('정상 수정');
                    this.post.id = data.id;
                } else {
                    alert('수정 실패 \n 데이터 확인요망');
                }
            })
            .catch(err => console.log(err));
        }
    }
}