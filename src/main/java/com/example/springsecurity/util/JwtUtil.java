package com.example.springsecurity.util;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * jwt工具类
 * 
 * @author xu
 */
public class JwtUtil {

    /**
     * 超时时间为一小时
     */
    public static final Long JWT_TTL = 60 * 60 * 1000L;

    /**
     * 密匙明文
     */
    public static final String JWT_KEY = "origin";

    public static String getUUID() {
        String token = UUID.randomUUID().toString().replace("_", "");
        return token;
    }

    /**
     * 生成加密后的密匙 SecretKey
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        /**
         * id 唯一id subject 主题，可以是JSON数据 issuedAt 签发时间 issuer 签发者 signWith(o1,o2) o1是使用的加密算法，o2是密匙 expiration 超时时间(过期时间)
         */
        return Jwts.builder().setId(uuid).setSubject(subject).setIssuedAt(now).setIssuer("gcp")
            .signWith(signatureAlgorithm, secretKey).setExpiration(expDate);
    }

    /**
     * 生成token
     * 
     * @param subject token中存放的数据
     */
    public static String createJWT(String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());
        return builder.compact();
    }

    /**
     * 生成token（自定义token过期时间）
     * 
     * @param subject token中存储的数据
     * @param ttlMillis token过期时间
     */
    public static String createJWT(String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }

    /**
     * 生成token（自定义id）
     * 
     * @param subject token中存储的数据
     * @param ttlMillis token过期时间
     * @param id id
     */
    public static String createJWT(String subject, Long ttlMillis, String id) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);
        return builder.compact();
    }

    /**
     * 解析token
     * 
     * @param token token
     */
    public static Claims parseJWT(String token) {
        SecretKey secretKey = generalKey();
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

}
