<template>
    <div :id="id" :style="{height:height+'px'}" ></div>
</template>

<script setup>
import * as echarts from 'echarts'
import useChart from './mixinchart';
import { onMounted,watch } from 'vue'
const id  = new Date().getTime()

const props = defineProps({
    height: {
        type: String,
        default: () => "400"
    },
    model: {
        type: Array,
        default: () => []
    },
    colorType: String,
    title: String,
    func: {
      type: Function,
    }
})

const color = []

const radius = ['70%']

const options = {
  legend: {
    top: '5%',
    right: '0',
    orient: 'vertical'
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
  series: [
    {
      color,
      name: 'Access From',
      type: 'pie',
      radius,
      // position: 'bottom',
      // avoidLabelOverlap: false,
      itemStyle: {
        borderRadius: 3,
        borderColor: '#fff',
        borderWidth: 2
      },
      label: {
        show: false,
        fontSize: '20',
        color: 'inherit',
        overflow: ''
        // position: 'center'
      },
      emphasis: {
        label: {
          show: true,
          fontSize: '20',
          fontWeight: 'bold'
        }
      },
      labelLine: {
        show: false
      },
      data: []
    }
  ]
}

let ChartEl

function init () {
  const element = document.getElementById(id)
//   element.style.width = props.width ? props.width + 'px' : element.style.width
//   element.style.height = props.height ? props.height + 'px' : element.style.height
  ChartEl = echarts.init(element)
  useChart(ChartEl)

}

function reder () {
  const element = document.getElementById(id)
  if (!!props.title) {
    options.title = { text: props.title, x: 'center', y: 'bottom' }
  }
  options.series[0].label.position = element.clientWidth < element.clientHeight * 2 ? 'center' : ''
  if (props.model && props.model.length === 2) {
    switch (props.colorType) {
      case 'red': color.splice(0, 2, '#ef6667', '#fcd3d3')
        break
      case 'green': color.splice(0, 2, '#01d677', '#c1fdd4')
        break
      case 'blue': color.splice(0, 2, '#5286ff', '#a0cfff')
        break
      default: color.splice(0, 2, '#5286ff', '#a0cfff')
    }
    radius.splice(0, 2, '40%', '70%')
  } else {
    radius.splice(0, 2, '70%')
    color.splice(0, 2)
  }
  const nowdata = options.series[0].data
  nowdata.push(...props.model)
  if (nowdata && nowdata.length > 2) {
    nowdata.sort((a, b) => b.value - a.value)
  }
}

// eslint-disable-next-line no-undef
onMounted(() => {
  init()
  reder()
  ChartEl.setOption(options)
  props.func&&ChartEl.on("click",props.func)
})

watch(props.model, () => {
  ChartEl.setOption({
    series:[{data:props.model}]
  },false,true)
})


</script>