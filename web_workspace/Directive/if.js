//if.js
let template = `
    <div>
        <label>
            <input type = "checkbox" v-model="myVisible"><h1>표시</h1>
        </label>
        <h1 v-if = "myVisible"> 체크박스가 ON </h1>
        <h1 v-else = "myVisible"> 체크박스가 OFF </h1>
        <h1 v-show = "myVisible"> show 디렉티브 </h1>
        <hr>
        <label>
            등급 : <input type = "text" v-model="score">
        </label>
        <p v-if="score >= 90">A</p>
        <p v-else-if="score >= 80">B</p>
        <p v-else-if="score >= 70">C</p>
        <p v-else-if="score >= 60">D</p>
        <p v-else>F</p>
        </div>
`;

export default{
    template,
    data(){
        return {
            myVisible : false,
            score : 0
        }
    }
}