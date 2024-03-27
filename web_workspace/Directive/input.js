//input.js
// template는 DOM에 등록되지 않는 유일한 태그, HTML 
// template >> 감싸는 부분 필요, 시각적으로 보이지 않음
// div태그 >> 시각적으로 보여줌
// myName 자리에 사용자가 입력 >> myName값을 p태그에 입력
// 프로퍼티 자체의 값을 바꿔서 인풋 태그와 바인딩되는 곳을 모두 적용
// select-option >> multiple 옵션하면 데이터 리턴값을 배열로 받기
// checkbox 여러개 >> 리턴값 배열로 받기, value 필요
// radio >> value 필요
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