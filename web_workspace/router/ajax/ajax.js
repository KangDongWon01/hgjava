/*서버 측에서 결정한다 라우팅(Routing)
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
    console.log(response);
    return response.json();
})
.then(data => {
    console.log(data);
})
.catch(err => console.log(err)); // 에러 처리는 반드시 필요함

// 같은 내용을 제이쿼리 방식
// $.ajax('https://jsonplaceholder.typicode.com/posts')
// .done(data => (){
//     console.log(data);
// })
// .catch(err => console.log(err));

// 단건조회
fetch('https://jsonplaceholder.typicode.com/posts/'+1)
.then(res => res.json())
.then(data => {
    console.log(data);
})
.catch(err => console.log(err)); // 에러 처리는 반드시 필요함

// 등록 Json : {객체}, [배열] , (객체 아니면 배열이다.)
let post = {
    id : 100,
    title : 'Hello!',
    userId : 10,
    body : 'Today is Friday!!!'
}

fetch('https://jsonplaceholder.typicode.com/posts',{
    method : 'post',
    headers : {
        'Content-type' : 'application/json'
    },
    body : JSON.stringify(post) //json 은 기본적으로 post방식으로 보낸다. get 방식으로는 거의 안 쓴다.
})
.then(res => res.json())
.then(data => {
    console.log(data);
})
.catch(err => console.log(err));

//수정 -> 누구를 수정할 것인가? 
fetch('https://jsonplaceholder.typicode.com/posts/'+1, {
    method : 'put',
    headers : {
        'Content-type' : 'application/json'
    },
    body : JSON.stringify({ //데이터의 수정할 부분만 집어 보내는 것은 안전하지 않을 확률 높다. 통째로 넘어가는게 대체로 안전하다고 판단된다.
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
    method : 'delete',
})
.then(response => {
    console.log(response);
    return response.json();
})
.then(data => {
    console.log(data);
})
.catch(err => console.log(err));