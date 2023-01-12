import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'
import 'element-plus/dist/index.css'; // EL

const pinia = createPinia()
createApp(App).use(pinia).use(router).mount('#app')
