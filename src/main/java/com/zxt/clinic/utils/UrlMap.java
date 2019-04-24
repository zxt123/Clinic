package com.zxt.clinic.utils;

public class UrlMap {

    public static final String VERSION_1_PREFIX = "/v1";

    public static final String USER_DOMAIN_PREFIX = "/user";
    public static final String SYS_DOMAIN_PREFIX = "/sys";

    public static final String CODE = VERSION_1_PREFIX + USER_DOMAIN_PREFIX + "/code";
    public static final String REGISTER = VERSION_1_PREFIX + USER_DOMAIN_PREFIX + "/register";
    public static final String LOGIN = VERSION_1_PREFIX + USER_DOMAIN_PREFIX + "/login";
    public static final String GET_BASE_INFO = VERSION_1_PREFIX + USER_DOMAIN_PREFIX + "/get/base_info";
    public static final String UPDATE_BASE_INFO = VERSION_1_PREFIX + USER_DOMAIN_PREFIX + "/update/base_info";
    public static final String GET_SECURE_INFO = VERSION_1_PREFIX + USER_DOMAIN_PREFIX + "/get/secure_info";
    public static final String UPDATE_SECURE_INFO = VERSION_1_PREFIX + USER_DOMAIN_PREFIX + "/update/secure_info";
    public static final String FORGET_SECURE_INFO = VERSION_1_PREFIX + USER_DOMAIN_PREFIX + "/forget/secure_info";
    public static final String DEVICE_BIND = VERSION_1_PREFIX + USER_DOMAIN_PREFIX + "/device/bind";
    public static final String DEVICE_UNBIND = VERSION_1_PREFIX + USER_DOMAIN_PREFIX + "/device/unbind";
    public static final String DEVICE_LIST = VERSION_1_PREFIX + USER_DOMAIN_PREFIX + "/device/list";
    public static final String DEVICE_UPDATE = VERSION_1_PREFIX + USER_DOMAIN_PREFIX + "/device/update";
    public static final String VALIDATE_TOKEN = VERSION_1_PREFIX + SYS_DOMAIN_PREFIX + "/validate/token";


}
