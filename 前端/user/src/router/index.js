import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
    {
        path: "/",
        name: "home",
        component: () => import("../view/home/HomePage.vue")
    },
    {
        path: "/login",
        name: "login",
        component: () => import("../view/login/denglu.vue")
    },
    {
        path: "/register",
        name: "register",
        component: () => import("../view/login/zhuce.vue")
    },
    {
        path: "/pages/",
        component: () => import("../view/home/index.vue"),

        children:[
            {
                path: "wordcloud",
                name: "wordcloud",
                component: () => import("../view/layout/wordclShow.vue")
            },
            {
                path: "likedgames",
                name: "likedgames",
                component: () => import("../view/layout/LikedGames.vue")
            },
            {
                path: "analyse/:gameId",
                name: "analyse",
                component: () => import("../view/layout/analyse.vue")
            },
            {
                path: "devtips/:gameId",
                name: "devtips",
                component: () => import("../view/layout/analyse2.vue")
            },
            {
                path: "charts",
                name: "charts",
                component: () => import("../view/layout/Charts.vue")
            },
            
        ]
    }
    // {
    //     path: "/wordcloud",
    //     name: 'wordcloud',
    //     component: () => import("../view/wordCloud/wordcloud.vue")
    // }
]

export default createRouter({
    history: createWebHashHistory(),
    routes
})