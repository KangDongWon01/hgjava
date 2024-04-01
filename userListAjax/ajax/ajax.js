// 전체조회
fetch('https://jsonplaceholder.typicode.com/users')
.then(response => {
    console.log(response); // 통신 결과 정보
    return response.json(); // 받은 결과 제이슨으로 파싱 >> 리턴
})
.then(data => { // 그러고 나서
    console.log(data); // 파싱 결과를 출력
})
.catch(err => console.log(err)); // 에러 처리는 필수

// 단건조회
fetch('https://jsonplaceholder.typicode.com/users/'+1) // rest방식 > 경로에 method 추가
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
    body : 'Today is Monday...'
}

fetch('https://jsonplaceholder.typicode.com/users',{
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
fetch('https://jsonplaceholder.typicode.com/users/'+1, { //특정 대상 지정해서 요청
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
fetch('https://jsonplaceholder.typicode.com/users/'+1, {
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