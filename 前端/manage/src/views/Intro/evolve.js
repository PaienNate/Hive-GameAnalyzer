// import * as echarts from './echarts.min'


// const callback = {
//     roomNum:null,
//     playerNum:null,
//     playerList:null
// }

// const proxy = new Proxy({
//     roomNum:0,
//     playerNum: 0,
//     playerList: '无',
// },{
//     get (target, prop, receiver) {
//         return Reflect.get(...arguments)
//     },
//     set (target,prop, receiver) {
//         if(callback[prop])callback[prop](receiver)
//         return Reflect.set(...arguments)
//     }
// })

// let chart_data = []

// const options = {
//     title: {
//       left: 'center',
//       top: 'bottom',
//       text: '三日内在线人数'
//     },
//     tooltip: {
//       trigger: 'axis',
//       position: function (pt) {
//         return [pt[0], '10%'];
//       }
//     },
//     xAxis: {
//       type: 'category',
//     },
//     yAxis: {
//       type: 'value'
//     },
//     series: [
//       {
//         data: chart_data,
//         type: 'line',
//         smooth: true,
//         symbol: 'none',
//         itemStyle: {
//           color: 'rgb(255, 70, 131)'
//         },
//         areaStyle: {
//           color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
//             {
//               offset: 0,
//               color: 'rgb(255, 158, 68)'
//             },
//             {
//               offset: 1,
//               color: 'rgb(255, 70, 131)'
//             }
//           ])
//         },
//       }
//     ]
//   };

// let chart;
import * as echarts from "echarts"
const numberDataElement = document.createElement("div");
numberDataElement.style.margin=" 0 5%"
numberDataElement.style.display = "flex";
numberDataElement.style.justifyContent = "space-between"
numberDataElement.innerHTML = 
    "<div class='my-tr'><span>{{roomNum}}</span><p>当前用户数量</p></div>"+
    "<div class='my-tr'><span>{{playerNum}}</span><p>当前日志总数</p></div>"+
    "<div class='my-tr'><span>{{playerList}}</span><p>本周盈利</p></div>"
const chartDataElement = document.createElement("div")
chartDataElement.style.height = "300px"
chartDataElement.id = "chart_show"
export function initTB(elementId,myOption) {
    const callback = {
        roomNum:null,
        playerNum:null,
        playerList:null
    }
    
    const proxy = new Proxy({
        roomNum:0,
        playerNum: 0,
        playerList: '无',
    },{
        get (target, prop, receiver) {
            return Reflect.get(...arguments)
        },
        set (target,prop, receiver) {
            if(callback[prop])callback[prop](receiver)
            return Reflect.set(...arguments)
        }
    })
    
    let chart_data = []
    
    const options = {
        title: {
          left: 'center',
          top: 'bottom',
          text: '用户操作耗时占比'
        },
        tooltip: {
          trigger: 'axis',
          position: function (pt) {
            return [pt[0], '10%'];
          }
        },
        xAxis: {
          type: "time",
          // min:min,
          // max:today,   //today为当前时间按小时取整。 如14:00
          show: true,
          minInterval: 3600 * 6 * 1000,   //12
          maxInterval: 3600 * 12 * 1000,
          Interval: 'auto',
          axisLabel:{
              show:true,
              // showMaxLabel:true,
              // showMinLabel:true,
              // formatter: '{MM}/{dd} {HH}:{mm}',
              // formatter: '{dd}日 {HH}:{mm}',
            },
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: chart_data,
            type: 'line',
            smooth: true,
            symbol: 'none',
            itemStyle: {
              color: 'rgb(255, 70, 131)'
            },
            areaStyle: {
              color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                {
                  offset: 0,
                  color: 'rgb(255, 158, 68)'
                },
                {
                  offset: 1,
                  color: 'rgb(255, 70, 131)'
                }
              ])
            },
          }
        ]
      };
    // console.log(elementId)
    const appRoot = document.getElementById(elementId);
    // console.log(appRoot)
    let fragment = document.createDocumentFragment();
    let child;
    while(child=appRoot.firstChild){
        fragment.append(child)
        console.error("检测到您指定的容器内含有其他子节点，现已排除")
    }
    fragment = document.createDocumentFragment();

    // const style = myOption?.style
    if(myOption.style){
        for(const key in myOption.style){
            appRoot.style[key] = myOption.style[key]
        }
        }else{
        console.log(appRoot.style)
        const mystyle = {
            width: '700px',
            height: '400px'
        }
        for(const key in mystyle){
            appRoot.style[key] = mystyle[key]
        }
    }

    fragment.append(numberDataElement);
    fragment.append(chartDataElement)
    Compile(fragment,proxy,callback)
    appRoot.append(fragment)
    const chart = echarts.init(document.getElementById('chart_show'))
    ReFreshData(chart, chart_data,options,proxy,myOption)
    if(myOption.listenTimeOut)setInterval(()=>{
        ReFreshData(chart, chart_data,options,proxy,myOption)
    },myOption.listenTimeOut*1000)

}

function Compile(fragment, datasource,callback) {
    fragment_compile(fragment)
    function fragment_compile(node) {
        //console.log(node)
        const pattern = /\{\{\s*(\S+)\}\}/
        if(node.nodeType===3){
            //  识别为文档的可插入节点对象
            const xxx = node.nodeValue
            //  将可插入对象作为模板
            const result_regex = pattern.exec(node.nodeValue)
            if(result_regex) {
                //  符合可以插入的对象
                callback[result_regex[1]]=newValue => {
                    node.nodeValue = xxx.replace(pattern, newValue)}
                const value = datasource[result_regex[1]]
                node.nodeValue = xxx.replace(pattern,value)
            }
        }
        node.childNodes.forEach(child => fragment_compile(child))
    }
}

function ReFreshData(chart, chart_data,options,proxy,myOption) {
    fetch(myOption.sourceHref,{
      mode: 'cors'
    }).then((res) => res.json()).then((data) =>{
            chart_data.splice(0,chart_data.length)
            proxy.roomNum=data.roomNum
            proxy.playerNum=data.playerNum
            proxy.playerList=data.playerList.join(",") + (data.playerNum > 3 ?  "" : "" )
            if(proxy.playerList==='')proxy.playerList='今日无人付费'
            // data.chartData.forEach((v,i,a)=>{
            //   a[i][0]=v[0].replace(' ','-')
            // })
            data.chartData.sort((a,b)=>{
              return new Date(a[0]).getTime() - new Date(b[0]).getTime()
            })
            chart_data.push(...data.chartData)
            // console.log(chart_data)
            chart.setOption(options)
        })
}