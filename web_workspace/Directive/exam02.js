//exam02.js => ForComponent
// 별찍기, 구구단 출력
let template = `
<div>
    <div>
        <p v-for = "line in 5" v-bind:key="line">
            <span v-for="num inline" key:"num">
            *
            </span>
        </p>
    </div>
        <template v-for="dan in 9" :key="dan"
            <div> v-if="dan%2 == 0"
</div>
`;
export default{
    template,
    data(){
        return {
            stars : ['*', '**', "***", "****"]
        }
    }
}