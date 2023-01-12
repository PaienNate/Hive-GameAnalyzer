package edu.hebeu.steam.util.baseutil;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenUtil {

    private static final long EXPIRE_TIME= 3*60*1000;
    private static final String TOKEN_SECRET="token123";  //密钥盐

    /**
     * 签名生成 - 验证交给sa-token
     * @return
     */
    public static String sign(String username,String passwdWithSalt){

        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0").withClaim("id","id")
                    .withClaim("username", username)
                    .withClaim("passwdWithSalt",passwdWithSalt)
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;

    }
}