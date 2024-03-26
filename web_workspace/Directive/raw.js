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