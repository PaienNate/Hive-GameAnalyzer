package edu.hebeu.steam.service;

import com.alipay.api.AlipayApiException;

public interface AliService {
    String CreateAliPayTask() throws AlipayApiException;
}
