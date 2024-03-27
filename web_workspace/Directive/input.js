//input.js
//template는 DOM에 등록되지 않는 유일한 태그, HTML 
let template = `
<div>
    <!--모델 바인드 -->
    <input type="text" v-model="myName"><br>
    <p> 나는 {{myName}} 입니다.</p>
    <input type = "number" v-model= "myNum"><br>
    <p> 계산결과 : {{myNum + 1000}} 입니다. </p>
    <textArea v-model.lazy="myComment"/>
    <div v-text = "myComment"/><br>

    <select v-model = "mySelect" multiple>
        <option>선택1</option>
        <option>선택2</option>
        <option>선택3</option>        
    </select><br>

    <!-- v-model 디렉티브 : checked 속성 -->
    <!-- checkbox 하나만 -->
    <input type="checkbox" v-model="myCheck" true-value = "확인" false-value = "미확인">확인여부<br>
    <p> 확인여부 : {{ myCheck}} </p>

    <!-- checkbox 여러개 -->
    <input type = "checkbox" v-model="myHobbies" value = "reading">독서
    <input type = "checkbox" v-model="myHobbies" value = "sports">운동
    <input type = "checkbox" v-model="myHobbies" value = "travel">여행
    <p> 취미 : {{ myHobbies}} </p>

    <!-- 예제 -->
    <input type = "checkbox" v-model="isAgreed">약관에 동의합니다.
    <br>
    <button type = "button" v-bind:disabled = "!isAgreed">회원가입</button>
    <br>
    <input type="radio" v-model = "myGender" value="Male">남자
    <input type="radio" v-model = "myGender" value="Female">여자 <br>
    <p> 성별 : {{ myGender }} </p>
   

</div>
`;

export default{
    template,
    data(){
        return {
            myName : '강동원', //문자열 초기값
            myNum : 0,
            myComment : '',
            mySelect : [],
            myCheck : '',
            myHobbies : [],
            isAgreed : false,
            myGender : ''
        }
    }
}