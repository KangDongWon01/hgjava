// text속성
// v-text >> 자바스크립트 부분, 함수호출도 가능, 닫는태그 없음, innerText사용x, innerText를 덮어씀
// 따옴표 >> 리터럴 문자열, vue문법 >> 변수
// {{}} >> vue 사용되는 부분, 연산가능, 자바스크립트 가능, 따옴표는 문자열
// 스타일 >> 여러개라서 객체 형태, 케밥표기법을 카멜표기법으로 바꾸기, 표기법 바꾸기 싫으면 따옴표로 문자열로 바꾸기, 스타일자체를 객체를 담은 변수로 가져오기
// 클래스 바인딩 >> 배열 형태, 객체x
// 불린타입 >> true/false 스타일 토글, 사용사 선택 가능
// 모델 디렉티브 >> 양방향, input-select-textarea(value속성), 속성표시x, :속성 대신 :프로퍼티
// 모델 디렉티브 >> 체크박스-라디오박스 다른 형태, checked, value속성 별도 바인딩 필요 :value,
let template = `
<div>
    <p v-text = "'Hello, ' + title + ((new Date()).getFullYear())"/>
    <p> Hello, {{ title + ' plus'}}! Today is ... </p>
    <!-- 바인드 디렉티브는 속성에 제한이 없다 -->
    <p v-bind:id = "postId" name="temp" text="Testing"/>
    <img v-bind:src = "fileName">
    <a v-bind:href="url">링크</a>
    <!-- bind 디렉티브 - style -->
    <p style = "color : blue;">문자색 직접 지정 </p>
    <p style = "color : blue; font-size : 200%;">두가지 속성을 직접 지정</p>
    <p v-bind:style="{ color : myColor }">vue방식</p>
    <p v-bind:style="{ color : myColor, fontSize : myFont }">vue방식</p>
    <p v-bind:style="myStyle">vue 방식</p>
</div>
`;

export default {
    template, //공간
    data : function(){ //data(){} 데이터 옵션은 함수의 형태를 지니고 있음. 리턴값에 원하는 유형의 프로퍼티 지정.
        return {
            title : 'Vue.js', //리턴되는 각 개체의 필드값을 프로퍼티 라고 부른다. 
            postId : 'raw',
            fileName : '강생이1.jpg',
            url : 'http://www.naver.com',
            myColor : 'green',
            myFont : '100px',
            myStyle : {
                color : 'red',
                fontSize : '200%'
            }
        }
    }
}