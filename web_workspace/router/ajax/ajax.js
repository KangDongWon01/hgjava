/*
라우터/라우팅(Routing)
특정 엔드 포인트에 대한 클라이언트 요청에
애플리케이션이 응답하는 방법을 결정하는 것
엔드 포인트 = 메소드(Method) + 경로(Path) + 데이터(data, 컨텐츠타입) >> 통신 요청 / post방식으로만 가능하

REST 방식...
겟방식, 포스트방식과 다른 새로운 아키텍쳐.
URI(자원) + METHOD(기능)
=> GET(조회), POST(등록), PUT(수정), DELETE(삭제)

REST 적용 전)
단건조회 : GET + empInfo?employeeId=100
전체조회 : GET + empList
등록 : POST + empInsert
수정 : POST empUpdate
삭제 : GET + empDelete?employeeId=100

REST 적용 후)
단건조회 : GET + emps/100
전체조회 : GET + emps
등록 : POST + emps
수정 : PUT emps/100
삭제 : DELETE + emps/100

REST .. Restful Server (http와 같은 새로운 하나의 아키텍쳐) 데이터 포맷 = 제이슨
쿼리 스트링이 아예 없지는 않음.
*/

// https://jsonplaceholder.typicode.com/posts

// 전체조회
fetch('https://jsonplaceholder.typicode.com/posts')
.then(response => {
    console.log(response); // 통신 결과 정보
    return response.json(); // 받은 결과 제이슨으로 파싱 >> 리턴
})
.then(data => { // 그러고 나서
    console.log(data); // 파싱 결과를 출력
})
.catch(err => console.log(err)); // 에러 처리는 필수

// 같은 내용을 제이쿼리 방식
// $.ajax('https://jsonplaceholder.typicode.com/posts')
// .done(data => (){
//     console.log(data);
// })
// .catch(err => console.log(err));

// 단건조회
fetch('https://jsonplaceholder.typicode.com/posts/'+1) // rest방식 > 경로에 method 추가
.then(res => res.json()) //위 전체조회 then을 화살표 함수로 축약
.then(data => {
    console.log(data);
})
.catch(err => console.log(err));

// 한건 등록 post방식, Json은 {객체}혹은 [배열] 타입
let post = {
    id : 100, //id 자동 부여 > 추가되어 출력됨
    title : 'Hello!',
    userId : 10,
    body : 'Today is Friday!!!'
}

fetch('https://jsonplaceholder.typicode.com/posts',{
    method : 'post', // post방식으로 정의, post방식은 body내용 필요
    headers : {
        'Content-type' : 'application/json' // body에 들어가는 데이터 타입 정의
    },
    body : JSON.stringify(post) // body > json 변환, json은 기본적으로 post방식으로 보냄
})
.then(res => res.json())
.then(data => {
    console.log(data);
})
.catch(err => console.log(err));

//수정 -> 누구를 수정할 것인가? 
fetch('https://jsonplaceholder.typicode.com/posts/'+1, { //특정 대상 지정해서 요청
    method : 'put', // put방식으로 정의, put방식은 rest에서 수정하는 방법
    headers : {
        'Content-type' : 'application/json'
    },
    body : JSON.stringify({ //데이터의 수정할 부분만 집어 보내는 것은 안전하지 않음, 모두 넘어가는게 안전
        title : 'edit',
        userId : 20,
        body : 'Test'
    })
})
.then(res => res.json())
.then(data => {
    console.log(data);
})
.catch(err => console.log(err));

//삭제
fetch('https://jsonplaceholder.typicode.com/posts/'+1, {
    method : 'delete', //delete방식 정의, delete방식은 rest에서 삭제하는 방법, 메소드만 정의
})
.then(response => {
    console.log(response);
    return response.json();
})
.then(data => {
    console.log(data);
})
.catch(err => console.log(err));