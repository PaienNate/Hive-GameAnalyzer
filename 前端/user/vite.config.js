import { fileURLToPath, URL } from 'node:url'
import { defineConfig, loadEnv } from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
import { createHtmlPlugin } from 'vite-plugin-html'

const getViteEnv = (mode, target) => {
  return loadEnv(mode, process.cwd())[target]
}

// https://vitejs.dev/config/
export default ({ mode }) =>
  defineConfig({
    server: {
      host: '0.0.0.0',
      port: 3000,
      https: false,
      proxy: {
        '/api': {
          changeOrigin: true,
            target: 'http://10.120.0.14:8080',
            // rewrite: (path) => path.replace(/^\/api/, '')

            // target: 'http://120.53.246.47:8080',
            rewrite: (path) => path.replace(/^\/api/, '')
        }
      }
    },
    build: {
      assetsDir: 'static'
    },
    plugins: [
      vue(),
      AutoImport({
        resolvers: [ElementPlusResolver()]
      }),
      Components({
        resolvers: [ElementPlusResolver()]
      }),
      createHtmlPlugin({
        inject: {
          data: {
            title: getViteEnv(mode, 'VITE_APP_TITLE')
          }
        }
      })
    ],
    resolve: {
      alias: {
        '@': fileURLToPath(new URL('./src', import.meta.url))
      }
    }
  })
