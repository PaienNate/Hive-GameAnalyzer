import { outResize, resize } from '@/method/chart';
import { onBeforeUnmount,onActivated } from 'vue'

export default function useChart(ChartEl) {
    resize(ChartEl)
    onActivated(() => {
        ChartEl.resize()
    })

    onBeforeUnmount(() => {
        outResize(ChartEl)
        ChartEl.dispose()
    })  
}

