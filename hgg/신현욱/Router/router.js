//router.js
import HomeComponent from '../views/home.js'
import postListComponent from '../views/postList.js';
import postInfoComponent from '../views/postInfo.js';
import PostUpdateComponent from '../views/postUpdate.js';
import PostInsertComponent from '../views/postInsert.js';
const {createRouter, createWebHistory} = VueRouter
let routes=[
    {
      path:'/index.html',
      redirect:'/'
    },
    {
        path:'/',
        name:'home',
        component:HomeComponent
    },
    {
        path:'/postList',
        name:'postList',
        component:postListComponent
    },
    {
        path:'/postInfo',
        name:'postInfo',
        component: postInfoComponent
    },
    {
        path:'/postUpdate',
        name:'postUpdate',
        component: PostUpdateComponent
    },
    {
        path:'/postInsert',
        name:'postInsert',
        component: PostInsertComponent
    }
  
]
const router = createRouter({
    history : createWebHistory(),
    routes 
});

export default router;