//exam01.js => ModelComponent

let template = `
<div>
    <h2>자기 소개</h2>
    <hr>
    <p>이름 입력 >><input type="text" v-model.lazy="myName"></p>
    <br>
    <p>좋아하는 색 선택 >>
    <br>
    <input type = "radio" v-model="myColors" v-bind:disabled="myName.length == 0" value = "red">빨강<br>
    <input type = "radio" v-model="myColors" v-bind:disabled="myName.length == 0" value = "green">녹색<br>
    <input type = "radio" v-model="myColors" v-bind:disabled="myName.length == 0" value = "blue">파랑<br>
    <input type = "radio" v-model="myColors" v-bind:disabled="myName.length == 0" value = "yellow">노랑<br>
    <input type = "radio" v-model="myColors" v-bind:disabled="myName.length == 0" value = "gray">회색<br>
    </p>
    <hr>
    <p> 내 이름은  {{ myName }} 이고, </p>
    <br>
    <p> 좋아하는 색은  {{ myColors }} 입니다. </p>
    <hr>
</div>
`;

export default{
    template,
    data(){
        return{
            myName : '',
            myColors : []
        }
    }
}