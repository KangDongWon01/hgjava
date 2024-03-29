//postList.js >> 전체조회

let template = `
<div>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>title</th>
                <th>userId</th>
            </tr>
        </thead>
        <tbody>
            <template v-for="post in postList" :key="post.id">
            <tr v-if="post.id <= 10" @click="goToDetail(post.id)"> 
                <td>{{post.id}}</td>
                <td>{{post.title}}</td>
                <td>{{post.userId}}</td>
            </tr>
        </tbody>
    </table>
</div>

`;

export default {
    template,
    data(){
        return {
            postList : []
        }
    },
    created(){
        this.getPostList(); //비동기
    },
    methods : {
        //getPostList(){
            //ajax
            //this.postList =
            //
            // fetch('')
            // .then(res=> res.json())
            // .then(data=>{
            //     this.postList = data;
            // })
            // .catch(err=> console.log(err));
            //
        //}
        async getPostList(){
            //비동기 통신의 순서를 동기식으로 진행
            this.postList = await fetch('https://jsonplaceholder.typicode.com/posts')
                                  .then(res => res.json())
                                  .catch(err => console.log(err));
        },    
        goToDetail(postId){
            this.$router.push({ name : 'postInfo',
                                query : { id : postId }
                            });
        }
    }
}