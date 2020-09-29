package com.boss.xtrain.user.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.boss.xtrain.exception.code.enums.system.AuthenticationCode;
import com.boss.xtrain.exception.type.BusinessException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author: moukex
 * @Description: 设置jwt
 * @Date: 2020/9/1 15:54
 * @Version: 1.0
 */
public class JwtUtils {
    /**
     * 设置加密用盐值
     */
    private static final String SIGNING_KEY = "72umyz33i9876gc31";
    /**
     * @Author moukex
     * @Version  1.0
     * @Description jwt生成token
     * @param  exp  过期时间
     * @param  claims 用户信息
     * @Return  Token令牌
     * @throw  BusinessException
     */
    public static String createJWT(Date exp, Map<String, Object> claims) {
        //token头部
        Map<String, Object> header = new HashMap<>();
        //加密算法
        header.put("alg", "HS256");
        //token类型
        header.put("typ", "JWT");
        //指定签名的时候使用的签名算法
        Algorithm algorithm = Algorithm.HMAC256(SIGNING_KEY);
        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        try {
            return JWT.create().withHeader(header)
                    .withClaim("userlogin", claims)
                    .withIssuedAt(now)
                    .withExpiresAt(exp)
                    .sign(algorithm);
        } catch (Exception e){
            throw new BusinessException(AuthenticationCode.AUTHENTICATION_CODE_TOKEN_CREATE_ERROR.getCode(),
                    AuthenticationCode.AUTHENTICATION_CODE_TOKEN_CREATE_ERROR.getMessage(), e);
        }
    }
/**
 * @Author moukex
 * @Version  1.0
 * @Description 解析token，传入token，解析出claim中的用户id，并返回map
 * @param token
 * @Return Map
 * @throw BusinessException
 */
    public static Map parseJWT(String token){
        try {
            return JWT.decode(token).getClaim("userlogin").asMap();
        } catch (Exception e){
            throw new BusinessException(AuthenticationCode.AUTHENTICATION_CODE_TOKEN_PARSING_ERROR.getCode(),
                    AuthenticationCode.AUTHENTICATION_CODE_TOKEN_PARSING_ERROR.getMessage(), e);
        }
    }




}
