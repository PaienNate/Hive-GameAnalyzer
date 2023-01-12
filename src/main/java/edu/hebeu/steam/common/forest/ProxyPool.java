package edu.hebeu.steam.common.forest;


import com.dtflys.forest.annotation.HTTPProxy;

@HTTPProxy(host = "${host}", port = "${port}")
public @interface ProxyPool {
}
