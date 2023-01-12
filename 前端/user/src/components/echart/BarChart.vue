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
  toolbox: {
    left:0,
    feature: {
      // dataZoom: {
      //   yAxisIndex: 'none'
      // },
      // restore: {},
      saveAsImage: {}
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
    type: 'category',
    position: 'top'
  },
  yAxis: {
    type: 'value',
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
  options.series.push(...GetSeries())
  useChart(ChartEl)
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
    series:[{data:props.model[0]},{data:props.model[1]}]
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