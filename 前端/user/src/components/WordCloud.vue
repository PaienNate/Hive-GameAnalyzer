<template>
  <div>
    <div ref="Chart2" style="height:800px;"></div>
  </div>
</template>

<script>
import 'echarts-wordcloud'
import * as echarts from 'echarts'
export default {
  props:{
    image: String,
    value: Array
  },
  data () {
    return {
      myChart: null,
      base64Data: '',
      textColor: {
        color1: {
          color: function () {
            return 'rgb(' +
              Math.round(Math.random() * 0.25 * 255) +
              ', ' + Math.round(Math.random() * 255) +
              ', ' + Math.round(Math.random() * 255) + ')'
          }
        },
        color2: {
          color: function () {
            return 'rgb(' +
              Math.round((Math.random() * 0.25 + 0.25) * 255) +
              ', ' + Math.round(Math.random() * 255) +
              ', ' + Math.round(Math.random() * 255) + ')'
          }
        },
        color3: {
          color: function () {
            return 'rgb(' +
              Math.round((Math.random() * 0.25 + 0.5) * 255) +
              ', ' + Math.round(Math.random() * 255) +
              ', ' + Math.round(Math.random() * 255) + ')'
          }
        },
        color4: {
          color: function () {
            return 'rgb(' +
              Math.round((Math.random() * 0.25 + 0.75) * 255) +
              ', ' + Math.round(Math.random() * 255) +
              ', ' + Math.round(Math.random() * 255) + ')'
          }
        }
      }
    }
  },
  created () {
  },
  mounted () {
    this.initEchart()
  },
  methods: {
    initEchart () {
      var that = this
      const maskImage = new Image()
      this.myChart = echarts.init(this.$refs.Chart2)
      maskImage.setAttribute('crossOrigin', 'anonymous')
      maskImage.src = this.$props.image
      // maskImage.src = this.image
      maskImage.onload = function () {
        that.myChart.setOption({
          backgroundColor: '#fff',
          tooltip: {
            show: false
          },
          series: [{
            type: 'wordCloud',
            gridSize: 1,
            sizeRange: [12, 55],
            rotationRange: [-45, 0, 45, 90],
            maskImage: maskImage,
            textStyle: {
              normal: that.textColor.color4
            },
            left: 'center',
            top: 'center',
            // width: '96%',
            // height: '100%',
            right: null,
            bottom: null,
            // width: 300,
            // height: 200,
            // top: 20,
            data: that.$props.value
          }]
        })
      }
    }
  }
}
</script>

<style lang='less' scoped>
</style>
