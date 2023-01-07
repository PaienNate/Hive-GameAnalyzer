package edu.hebeu.steam.forest;


import com.dtflys.forest.annotation.HTTPProxy;

@HTTPProxy(host = "${host}", port = "${port}")
public @interface ProxyPool {
}
