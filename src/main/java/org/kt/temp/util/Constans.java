package org.kt.temp.util;

public final class Constans {

    /**
     * Token过期时间，以秒为单位
     */
    public final static int TOKEN_EXPIRES_SECOND = 900;

    /**
     * 登录token key的前缀
     */
    public final static String LOGIN_TOKEN_KEY_PREFIX = "login:";

    /**
     * 请求传过来的token key
     */
    public final static String AUTHORIZATION = "access_token";

    /**
     * 小程序 appID
     */
    public final static String APPID = "wxa1b754a4e3748d74";

    /**
     * 小程序 appSecret
     */
    public final static String APPSECRET = "e85242f786c1821ad936cf90e1f48765";

    /**
     * 授权类型（grant_type），此处只需填写 authorization_code
     */
    public final static String GRANT_TYPE = "authorization_code";


}
