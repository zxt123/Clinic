package com.zxt.clinic.utils;

import org.apache.commons.codec.binary.Base64;
import redis.clients.jedis.Jedis;

public class CacheUtils {

    private static final Jedis jedis = new  Jedis("sMattress_Redis", 6379);

    private CacheUtils() {
    }

    private static String getRandNum() {
        int randNum = (int) System.currentTimeMillis();
        return String.valueOf(randNum & 0xFFFFF);
    }

    public static String makeCode(String account) {
        final String code = getRandNum();
        setCode(account, code);
        return code;
    }

    public static String getCode(String account) {
        final String code = jedis.get(String.format("code:%s",account));
        jedis.del(String.format("code:%s", account));
        return code == null || code.isEmpty() ? "" : code;
    }

    public static void setCode(String account, String code) {
        jedis.set(String.format("code:%s", account), code);
        jedis.expire(String.format("code:%s", account),60);
    }

    public static void removeCode(String account) {
        if (jedis.exists(String.format("code:%s", account))) {
            jedis.del(String.format("code:%s", account));
        }
    }

    public static String getToken(String account) {
        return jedis.get(String.format("token:%s", account));
    }

    public static void setToken(String account, String token) {
        final String key = String.format("token:%s", account);
        jedis.set(key, token);
        jedis.expire(key,30 * 24 * 60 * 60);
    }

    public static void refreshToken(String account) {
        jedis.expire(String.format("token:%s", account), 30 * 24 * 60 * 60);
    }

    public static void removeToken(String account) {
        if (jedis.exists(String.format("token:%s", account))) {
            jedis.del(String.format("token:%s", account));
        }
    }

    public static String getTokenExpiresIn(String account) {
        return String.valueOf(jedis.ttl(String.format("token:%s", account)));
    }

    public static String makeToken(String account) {
          final String  token = Base64.encodeBase64URLSafeString(getRandNum().getBytes());
            setToken(account, token);
        return token;
    }
}
