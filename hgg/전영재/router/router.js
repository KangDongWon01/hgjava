
import HomeComponent from '../views/home.js';
import BoardListComponent from '../views/boardList.js';
import BoardInfoComponent from '../views/boardInfo.js';
import BoardInsertComponent from '../views/boardInsert.js';
import BoardUpdateComponent from '../views/boardUpdate.js';




const { createRouter, createWebHistory } = VueRouter

let routes = [
    {
        path:'/index.html', 
        redirect: '/home'
    },
    {
        path:'/home',
        name:'home', 
        component: HomeComponent,
    },
    {
        path:'/boardList',
        name:'boardList', 
        component: BoardListComponent,
    },
    {
        path:'/boardInfo',
        name:'boardInfo', 
        component: BoardInfoComponent,
    },
    {
        path:'/boardInsert',
        name:'boardInsert', 
        component: BoardInsertComponent,
    },
    {
        path:'/boardUpdate',
        name:'boardUpdate', 
        component: BoardUpdateComponent,
    },
    
]

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;