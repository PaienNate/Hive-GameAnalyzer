<template>
    <div :id="id" :style="{ height: height + 'px' }"></div>
</template>

<script setup>
import * as echarts from 'echarts';
import useChart from './mixinchart';

import { onMounted, watch } from 'vue'
const id = new Date().getTime()
const props = defineProps({
    height: {
        type: String,
        default: () => "400"
    },
    title: String,
    model: {
        type: Array,
        default: () => []
    },
    func: {
        type: Function,
        default: null,
    },
    max: {
        type: Number,
        default: () => 4
    }
})
let year = 2023
const option = {
    title: {},
    tooltip: {
        formatter: function(parm){
            // console.log(arguments)
            return "日期："+parm.data[0]+"<br/>发布："+parm.data[1]+""
        },
        textStyle:{
            fontWeight: "bold"
        }
        // valueFormatter: (v)=> {
        //     console.log(v)
        //     return v
        // }
    },
    visualMap: {
        // show: false,
        left: 'center',
        top: 65,

        min: 0,
        max: props.max,
        type: 'piecewise',
        orient: 'horizontal',
        inRange: {
            color: ['#0e4429', '#006d32', '#26a641', '#39d353'],
        },
        outOfRange: {
            color: '#00000000',
        },
    },
    toolbox: {
        left: 0,
        feature: {
            myYear: {
                show:true,
                icon: "path://M863.74455 544.00086 163.424056 544.00086c-17.664722 0-32.00086-14.336138-32.00086-32.00086s14.336138-32.00086 32.00086-32.00086l700.320495 0c17.695686 0 31.99914 14.336138 31.99914 32.00086S881.440237 544.00086 863.74455 544.00086z",
                title: "展示年减少",
                onclick: () => {
                    year--
                    ChartEl.setOption(
                        {
                            title: { text: props.title+" "+year+"年" },
                            calendar: {
                                range: year
                            }
                        }
                    ,false,true)
                }
            },
            myYearAdd: {
                show:true,
                icon: "path://M533.333333 490.666667V128h-42.666666v362.666667H128v42.666666h362.666667v362.666667h42.666666V533.333333h362.666667v-42.666666z",
                title: "展示年增加",
                onclick: () => {
                    year++
                    ChartEl.setOption(
                        {
                            title: { text: props.title+" "+year+"年" },
                            calendar: {
                                range: year
                            }
                        }
                    ,false,true)
                }
            },
            saveAsImage: {}
        }
    },
    calendar: {
        top: 120,
        left: 30,
        right: 30,
        cellSize: ['auto', 13],
        range: year,
        itemStyle: {
            borderWidth: 0
        },
        splitLine: {
            lineStyle: {
                color: "#7776"
            }
        },
    },
    series: [
        {
            coordinateSystem: 'calendar',
            data: props.model,
            type: 'scatter',
            symbol: 'roundRect',

            symbolSize: 10,
        }
    ]
};

if (props.title) {
    option.title = { text: props.title+" "+year+"年", x: 'center', y: 'bottom' }
}else {
    option.title = { text: " "+year+"年", x: 'center', y: 'bottom' }
}
let ChartEl
function init() {
    const element = document.getElementById(id)
    //   element.style.width = props.width ? props.width + 'px' : element.style.width
    //   element.style.height = props.height ? props.height + 'px' : element.style.height
    ChartEl = echarts.init(element)
    useChart(ChartEl)
    props.func && ChartEl.on("click", props.func)
}
function reder() {
    ChartEl.setOption(option)
}
onMounted(() => {
    init()
    reder()
})

watch(props, () => {
    ChartEl.setOption({
        title: { text: props.title+" "+year+"年" },
        // calendar: {
        //     range: props.year
        // },
        series: [{ data: props.model }]
    }, false, true)
})

</script>