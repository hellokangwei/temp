package org.kt.temp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    private static final long EXPIRE_TIME = 1*60*1000;
    private static final String TOKEN_SECRET= "hello";

    /**
     * 生成签名，15分钟过期
     */
    public static String sign(String userName) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("Type","jwt");
            header.put("alg","HS256");
            // 返回token字符串
            return JWT.create().withHeader(header).withClaim("loginName",userName)
                    .withExpiresAt(date).sign(algorithm);
        } catch (Exception e){}
        return null;
    }


    /**
     * 验证token是否正确
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 从token中获取userName信息
     */
    public static String getUserName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("loginName").asString();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
