
import HomeComponent from '../views/home.js';
import BoardListComponent from '../views/boardList.js';
import InsertBoardComponent from '../views/insertBoard.js';
import BoardInfoComponent from '../views/boardInfo.js';
import UpdateBoardComponent from '../views/updateBoard.js';

const {createRouter, createWebHistory} = VueRouter

let routes = [
    {
        path: '/index.html',
        redirect: '/home'
    },
    {
        path: '/',
        name: 'home',
        component: HomeComponent
    },
    {
        path: '/boardList',
        name: 'boardList',
        component: BoardListComponent
    },
    {
        path: '/insertBoard',
        name: 'insertBoard',
        component: InsertBoardComponent
    },
    {
        path: '/boardInfo',
        name: 'boardInfo',
        component: BoardInfoComponent
    },
    {
        path: '/updateBoard',
        name: 'updateBoard',
        component: UpdateBoardComponent
    }
]

const router = createRouter({
    history: createWebHistory(), // 지금까지 접속했던 경로들 접근(고정)
    routes // routes 변수
})

export default router; // 라우터 통채로 default >> app.js >> use(router)