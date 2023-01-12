import request from "../request";

const rootUrl = "/user/"
//用户登录
export const userlogin = data => {
    return request("post",rootUrl+"login",data)
}

//用户注册
export const userreg = data => {
    return request("post","/regist",data)

}

//用户申请邮箱密码
//用户注册
export const useremail = data => {
    //let datas = qs.stringify(data);
    return request("post",rootUrl+"resetPasswd",data)
}


//用户注册
export const userchangepass = data => {
    //let datas = qs.stringify(data);
    return request("post",rootUrl+"modifyPasswd",data)
}

