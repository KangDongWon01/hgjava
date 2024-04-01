//router.js
import HomeComponent from '../views/home.js'
import BoardListComponent from '../views/boardList.js'
import BoardComponent from '../views/board.js'
import CommentComponent from "../components/comment.js";
import BoardForm from "../views/boardForm.js"
const {createRouter, createWebHistory} = VueRouter

let routes=[
    {
        path:'/index.html',
        redirect : '/home'
    },
    {
        path:'/home',
        name:'home',
        component : HomeComponent
    },
    {
        path:'/boardList',
        name:'boardList',
        component : BoardListComponent
    },
    {
        path:'/board',
        name:'board',
        component : BoardComponent
    },
    {
        path:'/comment',
        name:'comment',
        component : CommentComponent
    },
    {
        path:'/boardForm',
        name:'boardForm',
        component : BoardForm
    },
    
]

const router = createRouter({
    history : createWebHistory(),
    routes
})
export default router;