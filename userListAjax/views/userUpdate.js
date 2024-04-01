//userUpdate.js

let template = `
<div>
    <table>
        <tr>
            <th>id</th>
            <td><input type="text" v-model="user.id" readonly></td>
        </tr>
        <tr>
            <th>name</th>
            <td><input type="text" v-model="user.name"></td>
        </tr>
        <tr>
            <th>username</th>
            <td><input type="text" v-model="user.username"></td>
        </tr>
        <tr>
            <th>email</th>
            <td><textarea v-model="user.email"/></td>
        </tr>
        <tr>
            <button type="button" @click="updateteUserInfo()">등록</button>
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
                name : '',
                username : '',
                email : ''    
            }
        }
    },
    created() {
        let id = this.$route.query.id;
        this.getUserInfo(id);
    },
    methods : {
        async getUserInfo(id){
            this.user = await fetch('https://jsonplaceholder.typicode.com/users/'+id)
                                .then(res => res.json())
                                .catch(err => console.log(err));
        },
        updateUserInfo() {
            let data = {
                id : this.user.id,
                name : this.user.name,
                username : this.user.username,
                email : this.user.email
            }

            fetch('https://jsonplaceholder.typicode.com/users/'+data.id, {
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
                    alert('정상 등록');
                    this.user.id = data.id;
                } else {
                    alert('저장 실패 \n 데이터 확인요망');
                }
            })
            .catch(err => console.log(err));
        }
    }
}