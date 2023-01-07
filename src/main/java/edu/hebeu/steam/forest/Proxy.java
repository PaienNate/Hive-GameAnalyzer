package edu.hebeu.steam.forest;

import com.alibaba.fastjson.annotation.JSONField;

@lombok.NoArgsConstructor
@lombok.Data
public class Proxy {
    @JSONField(name = "anonymous")
    private String anonymous;
    @JSONField(name = "check_count")
    private Integer checkCount;
    @JSONField(name = "fail_count")
    private Integer failCount;
    @JSONField(name = "https")
    private Boolean https;
    @JSONField(name = "last_status")
    private Boolean lastStatus;
    @JSONField(name = "last_time")
    private String lastTime;
    @JSONField(name = "proxy")
    private String proxy;
    @JSONField(name = "region")
    private String region;
    @JSONField(name = "source")
    private String source;

    public String getProxyIp()
    {
        return proxy.split(":")[0];
    }
    public String getProxyport()
    {
        return proxy.split(":")[1];
    }
}
