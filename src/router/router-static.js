import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import adminexam from '@/views/modules/shijuanliebiao/exam'
    import yuangong from '@/views/modules/yuangong/list'
    import yimiaoleixing from '@/views/modules/yimiaoleixing/list'
    import yimiaomingcheng from '@/views/modules/yimiaomingcheng/list'
    import zuixingonggao from '@/views/modules/zuixingonggao/list'

//2.配置路由   注意：名字
const routes = [
    {
        path: '/index', name:'index', component: Index, children: [{
            // 这里不设置值，是把main作为默认页面
            path: '/',
            name: 'home',
            component: Home
        },{
            path: '/updatePassword',
            name: 'updatePassword',
            component: UpdatePassword
        } ,{
            path: '/pay',
            name: 'pay',
            component: pay
        } ,{
            path: '/center',
            name: 'center',
            component: center
        } 
                    ,{
                path: '/yuangong',
                name: 'yuangong',
                component: yuangong
            } 
                    ,{
                path: '/yimiaoleixing',
                name: 'yimiaoleixing',
                component: yimiaoleixing
            } 
                    ,{
                path: '/yimiaomingcheng',
                name: 'yimiaomingcheng',
                component: yimiaomingcheng
            } 
                    ,{
                path: '/zuixingonggao',
                name: 'zuixingonggao',
                component: zuixingonggao
            } 
                ]
    },
    { path: '/adminexam', name: 'adminexam', component: adminexam },
    { path: '/login', name:'login', component: Login },
    { path: '/register', name:'register', component: register },
    { path: '/', redirect: '/index/' },      /*默认跳转路由*/
    { path: '*', component: NotFound }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
    mode: 'hash',   /*hash模式改为history*/
    routes // （缩写）相当于 routes: routes
})

export default router;

