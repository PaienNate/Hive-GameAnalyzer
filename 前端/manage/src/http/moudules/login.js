import axios from '../axios'
import qs from "qs"

/* 
 * 系统登录模块
 */

// 登录
export const login = data => {
    return axios({
        url: '/login',
        method: 'post',
        data
    })
}
//用户登录
export const userlogin = data => {
    return axios({
        url: '/user/login',
        method: 'post',
        data
    })
}

//用户注册
export const userreg = data => {
    return axios({
        url: '/regist',
        method: 'post',
        data
    })
}

//用户申请邮箱密码
//用户注册
export const useremail = data => {
    //let datas = qs.stringify(data);
    return axios({
        url: '/user/resetPasswd',
        method: 'post',
        data
    })
}


//用户注册
export const userchangepass = data => {
    //let datas = qs.stringify(data);
    return axios({
        url: '/user/modifyPasswd',
        method: 'post',
        data
    })
}


// 登出
export const logout = () => {
    return axios({
        url: 'logout',
        method: 'get'
    })
}
