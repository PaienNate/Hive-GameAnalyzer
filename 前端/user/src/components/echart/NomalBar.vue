<template>
    <div :id="id" :style="{height:height+'px'}" ></div>
</template>

<script setup>
import useChart from './mixinchart';
import * as echarts from 'echarts'
import { onMounted,watch } from 'vue'
const id  = new Date().getTime()

const props = defineProps({
    height: {
        type: String,
        default: () => "400"
    },
    model: {
        type: Array,
        default: () => [[],[]]
    },
    colorType: String,
    title: String,
    func: {
      type: Function,
    },
    dataZoom:{
        type:Boolean,
        default:()=>false
    },
    x:{
        type:Boolean,
        default:()=>false
    }
})


const options = {
  tooltip: {
    trigger: 'axis',
    axisPointer: {
      // Use axis to trigger tooltip
      type: 'shadow' // 'shadow' as default; can also be 'line' or 'shadow'
    }
  },
  dataZoom: [
  {
            //   width: "480",
            //   height: 10, //组件高度
            //   left: 50, //左边的距离
            //   right: 65, //右边的距离
            //   bottom: 40, //下边的距离
              zoomLock:false, //是否锁定选择区域（或叫做数据窗口）的大小。如果设置为 true 则锁定选择区域的大小，也就是说，只能平移，不能缩放。
              start: 0,//数据窗口范围的起始百分比,表示0%
       		    end: 20,//数据窗口范围的结束百分比,表示70%
              type: "slider",
            //   xAxisIndex: 0,
              fillerColor: "#fff3e4",
              backgroundColor: "#eee", //两边未选中的滑动条区域的颜色
              showDetail: false,
              showDataShadow: false, //是否显示数据阴影 默认auto
              textStyle: {
                color: "#fff",
                fontSize: "12"
              }
            },
    // {
    //     // type:"inside",
    //   start: 0,
    //   end: 20
    // }
  ],
  toolbox: {
    left:0,
    feature: {
      saveAsImage: {},
    }
  },
  legend: {},
  grid: {
    left: '3%',
    right: '4%',
    // bottom: '3%',
    containLabel: true
  },
  xAxis: {
      type: 'value',
  },
  yAxis: {
    type: 'category',
  },
  series: [
  ]
};

let ChartEl

function init () {
  const element = document.getElementById(id)
//   element.style.width = props.width ? props.width + 'px' : element.style.width
//   element.style.height = props.height ? props.height + 'px' : element.style.height
  ChartEl = echarts.init(element)
  props.func&&ChartEl.on("click",props.func)
  if (!!props.title) {
    options.title = { text: props.title, x: 'center', bottom:0 }
  }
  options.series.push({
    data: props.model,
    type: 'bar'
  })
  useChart(ChartEl)
  if (props.x) {
        options.xAxis.type = 'category'
        options.yAxis.type = 'value'
  }
  if (props.dataZoom){
    if (props.x) {
        options.dataZoom[0].xAxisIndex=0
        options.dataZoom[0].height=10
        options.dataZoom[0].bottom=40
    }else {
        options.dataZoom[0].yAxisIndex=0
        options.dataZoom[0].width=20
    }
  }else{
    options.dataZoom = []
  }
  
}

function reder () {
  ChartEl.setOption(options)
}

// eslint-disable-next-line no-undef
onMounted(() => {
  init()
  reder()
})

watch(props.model, () => {
  ChartEl.setOption({
    series:[{data:model}]
  },false,true)
})



const GetSeries = () => {
    return [
        {
            name: "已使用",
            type: "bar",
            stack: "total",
            label: {
                show:true,
            },
            emphasis:{
                focus: "series"
            },
            data: props.model[0]
        },
        {
            name: "未使用",
            type: "bar",
            stack: "total",
            label: {
                show:true,
            },
            emphasis:{
                focus: "series"
            },
            data: props.model[1]
        }

    ]
}

</script>