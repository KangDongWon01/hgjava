//Comment.js

let template=`
<table>
    <template v-for="comment in comments" :key="comment.no">
        <tr>
            <p>{{comment.content}}</p>
            <p>{{comment.writer}}       {{getDate(comment.createdDate)}}</p>
        </tr>

    </template>
</table>
`;

export default{
    template,
    data(){
       return {
        comments :{}
       }
   },
   created(){
    let no = this.$route.query.no;
    this.getComment(no);
   },
   methods : {
    async getComment(no){
        this.comments = await fetch('http://localhost:8099/comments/'+ no)
                                .then(res=>res.json())
                                .catch(err=>console.log(err));
    },
    getDate(date){
        return new Date(date).toLocaleDateString().replace(/\./g, '').replace(/\s/g, '-') 
    }
   }

}