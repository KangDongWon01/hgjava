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
        }
    }
}