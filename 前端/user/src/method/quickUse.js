import {throttle } from "./method"; 
import { ElMessage } from 'element-plus'
export const msgSuccess=throttle(
    str=>ElMessage({
        message: str,
        type: 'success',
      }),
    1000
)
export const msgInfo=throttle(
    str=>ElMessage({
        message: str,
        type: 'info',
      }),
    1000
)
export const msgPrimary=throttle(
    str=>ElMessage({
        message: str,
        type: 'primary',
      }),
    1000
)
export const sayError=throttle(
    str=>ElMessage({
        message: str,
        type: 'danger',
        // duration:0
      }),
    1000
)

export const sayWarning = throttle(
  str=>ElMessage({
    message: str,
    type: 'warning',
    // duration:0
  }),
  1000
)
