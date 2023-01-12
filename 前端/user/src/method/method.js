/**
 * 防抖
 * @param {Function} fun 处理的方法
 * @param {number} delay 延迟时间
 * @returns
 */
export function debounce(fun, delay) {
  let timerId = null
  return function () {
    const context = this
    // console.log(timerId)
    timerId && clearTimeout(timerId)
    timerId = setTimeout(() => {
      fun.apply(context, arguments)
      timerId = null
    }, delay)
  }
}

/**
 * 节流
 * @param {Function} fun 处理的方法
 * @param {number} delay 延迟时间
 * @returns
 */
export function throttle(fun, delay) {
  let canUse = true
  return function () {
    if (canUse) {
      canUse = false
      setTimeout(() => {
        canUse = true
      }, delay)
      return fun.apply(this, arguments)
    }
  }
}

/**
 * @function: setStyle
 * @param {HTMLElement} el 元素
 * @param {Object} css css样式 例: { width: 100px }
 * @description: DOM设置样式
 */
export function setStyle(el, css) {
  Object.keys(css).forEach((key) => {
    el.style[key] = css[key]
  })
}

/**
 * @function: minmax
 * @param {Number} num 需要限制的数
 * @param {Number[]} limit 限制范围 传入一个数组 一个作为最小值另一个作为最大值
 * @return {Number} 返回限制后的数
 * @description: 用于限制数的最大和最小值
 */
export function minmax(num, limit = []) {
  if (!limit.length || limit.length === 1) return num
  let min, max
  ;(limit[0] - limit[1] && ((min = limit[0]), (max = limit[1]))) ||
    ((min = limit[1]), (max = limit[0]))
  return Math.min(max, Math.max(min, num))
}
