import axios from "axios";
import qs from "qs";
// import userStore from "../store/userStore";
import { sayError,sayWarning } from "../method/quickUse";
const http = axios.create({
  baseURL: "/api",
  timeout: 10000,
});

window.http=http
window.axios = axios

console.log(http)
// HTTP状态码
http.httpcode = {
    OK: 200,

};

http.interceptors.request.use((config={}) => {
  console.log(config)
  try {
    if (config.ContentType === "application/x-www-form-urlencoded") {
      config.data =
        config.data && qs.stringify(config.data, { indices: false });
    }
    // let token = userStore().token
    // if (token) {
    //   config.headers.common.Authorization = token
    // }
  } catch (e) {
    // console.log(e);
  }
  // console.log(config);
  return config;
});

http.interceptors.response.use(
  async (response) => {
    // HTTP响应状态码正常
    if (response.status === 200) {
      // nprogress.done();
      if ('code' in response.data) {
        // const store = userStore();
        const data = response.data;
        switch (data.code) {
          case http.httpcode.OK:
            return Promise.resolve(data);
          default:
            // 显示操作失败提示
            // ElMessage.error(response.data.message || "操作失败!!!");
            sayWarning("Error Code"+data.code+": "+data.msg)
            return Promise.reject(data);
        }
      }
      sayError("请确认您的后端包装是否正确")
      return Promise.reject(response);
    } else {
      sayError("连接不到服务器")
      return Promise.reject(response);
    }
  },
  (error) => {
    if (error.code === 'ECONNABORTED' || error.code === 'ERR_NETWORK')
      sayError();
    return Promise.reject(error);
  }
);


export default function (method, url, submitData, ContentType) {
  let file
  switch (ContentType) {
    case "form":
      ContentType = "application/x-www-form-urlencoded";
      break;
    case "file":
      ContentType = "multipart/form-data";
      file = new FormData();
      file.append('file',submitData);
      submitData = file;
      break;
    case "files":
      ContentType = "multipart/form-data";
      file = new FormData();
      // console.log(submitData)
      for(let i = 0;i<submitData.length;i++) {
        file.append('file',submitData[i]);
      }
      submitData = file;
      break;
    case "rest":
      url+='/'+submitData;
      submitData=null;
      break;
    default:
      ContentType = "application/json";
  }
  return new Promise((resolve, reject) => {
    const reqParams = {
      method,
      url,
      [method.toLowerCase() === "get" //|| method.toLowerCase() === "delete"
      ? "params"
      : "data"]: submitData,
      ContentType,
      // paramsSerializer: function (params) {
      //   return qs.stringify(params, { indices: false });
      // },
    };
    console.log(reqParams)
    http(reqParams)
      .then((res) => {
        resolve(res.data||res);
      })
      .catch((err) => {
        // console.log(err);
        reject(err);
      });
  });
}
