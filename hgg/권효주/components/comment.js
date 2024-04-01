// comment.js

let template = `
<div>
    <p>{{ bno }}</p>
    <p>{{comment.content}}</p>
    <p>{{comment.writer}} &ensp; {{comment.createdDate}}</p>
</div>
`;

export default {
    template,
    data() {
        return {
            no : this.$props[0],
            comment : {
                createdDate : '',
                writer : '',
                content : ''
            }
        }
    },
    created() {
        this.getComment();
    },
    methods : {
        async getComment() {
            this.comment = await fetch('http://localhost:8099/comments/' + this.no)
                                  .then(res => res.json())
                                  .catch(err => console.error(err));
        }
    },
    props : ['bno']
}
