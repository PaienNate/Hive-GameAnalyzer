import { throttle } from "./method"

const chartResizeList = []

export function resize(chart) {
    chartResizeList.push(chart)
    if (!window.onresize) {
        window.onresize = throttle(() => {
            chartResizeList.forEach(v=>{
                if ("resize" in v&&typeof v["resize"] === "function"){
                    v["resize"]()
                }
            })
        },30) 
        
    }
}

export function outResize(chart) {
    let index = chartResizeList.indexOf(chart)
    chartResizeList.splice(index,index+1)
}