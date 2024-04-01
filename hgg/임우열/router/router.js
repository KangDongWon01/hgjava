// router.js

import HomeComponent from '../views/home.js';
import boardListComponent from '../views/boardList.js';
import boardInfoComponent from '../views/boardInfo.js';
import boardUpdateComponent from '../views/boardUpdate.js';
import boardInsertComponent from '../views/boardinsert.js';
import boardFormComponent from '../views/boardForm.js';

const { createRouter, createWebHistory } = VueRouter
let routes = [
    {
        path: '/index.html',
        redirect: '/'
    },
    {
        path: '/',
        name: 'home',
        component: HomeComponent
    },
    {
        path: '/boardList',
        name: 'boardList',
        component: boardListComponent
    },
    {
        path: '/boardInfo',
        name: 'boardInfo',
        component: boardInfoComponent
    },
    {
        path: '/boardUpdate',
        name: 'boardUpdate',
        component: boardUpdateComponent
    },
    {
        path: '/boardinsert',
        name: 'boardinsert',
        component: boardInsertComponent
    },
    {
        path: '/boardForm',
        name: 'boardForm',
        component: boardFormComponent
    }

]
const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;