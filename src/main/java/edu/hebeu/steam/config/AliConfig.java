package edu.hebeu.steam.config;

public class AliConfig {
    // 支付宝网关：沙箱环境
    public static final String URL = "https://openapi.alipaydev.com/gateway.do";
    // APPID (请自行填写，真实环境请做对应修改)
    public static final String APP_ID = "2021000122602456";
    // 应用私钥 (请自行填写，真实环境请做对应修改)
    public static final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCcxf6LhAJfylgV0KmTk6Q5BIYbBxWtPUfEz+OrUOpTbt/UdYDZfgMwMzL7DgS+U/Is8fy74MHSsPOHT6n9/j4ojKc091pWLLjMnhpVfR5xb/gtAmkg0vYkC+S87C1lKNGAbat+tkV7Bxd2bg+A/rao3aQHDATk7IRZ6FjStq1WX9/db6Y0qu8ljBDb7TramVq/EsiEDJ1ADmDmUu+YDP1JE7jbcJjmCCzJGN4BYePKvkYrpRiLps3RXC0xWoh4ZLQYPDGFErr8Vdy030pDA+kxvYt0EQqpW4Gdf7bMpHmMW1q8gsVjIb7JiiUS3BYsb3KYcSTQTN4Y3Kx08kSx/s7PAgMBAAECggEAWuiJMXfMNKXOLGBCZTxBB3szFKsoC7w0SNFQMQCL0PPDQZ0dqYDj8mhOELzRTVi6Xwu3xW6Qlk9b+EPezFVI0BS3xQQGU2A9jRHFLXuPUrJeFCOIuKr8ZmyrKE5ACKAB1FpEDwc9BRlYpqktvlx1qThVLGzwzZrFKKmOECo0G5g10BLsTJ9x+aypNOequon+fZpqFk4mKxKqA5UvMcCRsWPdXXGUnZnjxXwlsbi+y+Y535X9Qcz9nNmOjKaonLb9OKAiyyez9nY2fs7/tmHH9Px/uztR7hF1yLmFUEl1OYzzGANij9cS7fOClKMHMrGSoX7wRT985Y6CLv8QvJ7umQKBgQDZAtAsvgEl/6UN16IORrbmeEzQ03EoyXKyJfjvVTLJdDUwjkfDKJGRIS4vVwJwRvxdOGSGOE2ofhOx6bvqmD5VuiiJAjDoIG82i704y8PlCy8POMyI8ljMs3rO0qxLR403SqBpdIo7RFWhJGdDlefiiw45SmFbzKx7Nidqwgk+wwKBgQC48J5oWYDitG6Dcow1fQlxmtfVlfhkgp6/PzcU3HgBGAo9QAYpqOoGhKqJtgRYi32Xgm08AE0jj72JJf9NGs4853KthWenNOLuUCqqv3yneVl48HQr9z0ZGGWIEqjZul9036YvvzzwWhwo9p3cf739anORJ33y2rSkuPJsFW3HBQKBgQC0ZRlGSEBOJSBAzILDWVdLaK96XHpRzHwSyWwREALi4j4g+fV/ruaq/SkWYz78tJWurGUsCfvMV9npaII0tpAC1XhCxFaBcAzjC/ClGQXkDZL2FWI5aTQWHhC1gv2EqpsiXl/QqfcK43hHNyq8TQ3xDWUqjME3/YFX/yFvJpNm3wKBgEVu6ToqKE51CWzGa8eFKy+Av/nLdVdfBvSsaiSl5VQbz3RRfj7T0REja9eKA7WuoTdp21MElfF8/N7p6iDrqHSLPK3TAShwnaZ1aJ90hvtlfub998+t4j1ywGPHBafA5ie98+nHNbzTR/FFLd1kBFOJTNw5ZHryC5IwcauMnAt1AoGBALC5mKPCFovStrxPjVhpeTTsT9oaL0ArbuVGk+rpk/5EQXUSIdXUoZI5ZZ445KE5FPYAGe413Vq9s/gQjspUkXzYVvuA7XLHImT+aAFWJbGfVGtfnUXdej0Ta+OiXEFEYIwpLX6Ujh6shyD6T5H9+15fRpYl1uIX26r5oSUUEhlE";
    // 数据返回的格式 (只支持json格式)
    public static final String FORMAT = "json";
    // 验签编码 (根据需要修改)
    public static final String CHARSET = "UTF-8";
    // 支付宝公钥 (请自行填写，真实环境请做对应修改)
    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgkRyIhi0u9iok6IVNedgCMMyqaGdFonHXbw3q2yRRQP1XvuN+inU5/mhr5cG4GmLggReDg3KTaFfSFiN588IX6PKRBVo0eSQ5gx+fTww/C3+If/BofcB+nofh7iRCaRzUgh1BUr7kTUYfINIPGYNsFYwick+B3FQwKWl9peeF5mpw5/BN94nd/nvHHwd+uG65CU85xfAnuBmTQRhwsU/voMZPfPNq4aYZdQs7dQhFChlDfQSAJ7N3dyrxxiLS/rFGj48csfBsLSuDBFGd9cqmEFfK67B0kRoRplvn+8aqwq4Z3vFgYq4GcMM2kGWZ6NWqF8mFf50/9Fj50CaotpNywIDAQAB";
    // 验签加密方法 (根据需要修改)
    public static final String SIGN_TYPE = "RSA2";
    //支付宝异步回调位置
    public static final String NOTIFY_URL="http://112.126.67.230:25570/call";
}
