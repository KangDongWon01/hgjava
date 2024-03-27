//if.js
// if 디렉티브 >> 생성 제어, 조건을 만족하지 않으면 해당 태그 생성x
// if 디렉티브 >> 여러개 있어도 조건에 맞는 하나의 태그만 출력
// if 디렉티브 >> for디렉티브보다 우선순위가 높고 함께 사용할 수 없음
// show >> 조건을 만족하지 않아도 해당 태그 생성, 자주 필요한 경우
// template태그에 v-for사용 >> 자식으로 div태그와 v-if 사용
// template태그 >> 반복문 가짐, 숨기

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