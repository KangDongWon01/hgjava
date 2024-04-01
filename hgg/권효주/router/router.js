// router.js

import HomeComponent from '../views/home.js';
import BoardListComponent from '../views/boardList.js';
import BoardComponent from '../views/board.js';
import BoardFormComponent from '../views/boardForm.js';

const { createRouter, createWebHistory } = VueRouter

let routes = [
    {
        path : '/index.html',
        redirect : '/home'
    },
    {
        path : '/',
        redirect : '/home'
    },
    {
        path : '/home',
        name : 'home',
        component : HomeComponent
    },
    {
        path : '/boardList',
        name : 'boardList',
        component : BoardListComponent
    },
    {
        path : '/board',
        name : 'board',
        component : BoardComponent
    },
    {
        path : '/boardForm',
        name : 'boardForm',
        component : BoardFormComponent
    }
]

const router = createRouter({
    history : createWebHistory(),
    routes
});

export default router;