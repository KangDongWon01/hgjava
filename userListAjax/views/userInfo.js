//userInnfo.js
let template = `
<div>
    <table>
        <tr>
            <th>id</th>
            <td>{{userInfo.id}}</td>
        </tr>
        <tr>
            <th>name</th>
            <td>{{userInfo.name}}</td>
        </tr>
        <tr>
            <th>username</th>
            <td>{{userInfo.username}}</td>
        </tr>
        <tr>
            <th>email</th>
            <td>{{userInfo.email}}</td>
        </tr>
    </table>
<div>
`;
export default{
    template,
    data() {
        return{
            userInfo : {}
        }
    },
    created() {
        let id = this.$route.query.id; //무슨 의미인지 까먹었다. 안 읽힘..
        this.getUserInfo(id);
    },
    methods : {
        async getUserInfo(id) {
            this.userInfo = await fetch('https://jsonplaceholder.typicode.com/users/' + id)
                                    .then(res => res.json())
                                    .catch(err => console.log(err));
        }
    }
}