// router.js
// 라우터는 겟 방식만 사용가능, 서버는 아님.
import HomeComponent from '../views/home.js'
import PostListComponent from '../views/postList.js'
import PostInfoComponent from '../views/postInfo.js'


const { createRouter, createWebHistory } = VueRouter
let routes = [ //따로 빼는것이 편의상 좋다.
    {
        path : '/index.html', //정규표현식..
        redirect : '/home'
    },
    {
        path : '/home',
        name : 'home',
        component : HomeComponent
    },
    {
        path : '/postList',
        name : 'postList',
        component : PostListComponent
    },
    {
        path : '/postInfo',
        name : 'postInfo',
        component : PostInfoComponent
    }
]

const router = createRouter({
    //브라우저가 가진 히스토리, 뒤로가기나 앞으로가기.. 
    //이런 경로들을 히스토리(자바스크립트 내장 객체임) 객체에서 접근함.
    history : createWebHistory(),
    routes
});

export default router; // 라우터 통째로 default