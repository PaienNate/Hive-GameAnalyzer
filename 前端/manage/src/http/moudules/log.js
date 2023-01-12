import axios from '../axios'

/* 
 * 日志管理模块
 */

// 分页查询
export const findPage = (data) => {
    return axios({
        url: '/log/findPage',
        method: 'post',
        data
    })
}
// 分页查询 支付宝日志
export const findPage_ali = (data) => {
    return axios({
        url: '/ali/findPage',
        method: 'post',
        data
    })
}