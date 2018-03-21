package cn.suqc.util;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
/**
 * 网站全局变量类
 * @author LIUTIE
 *
 */
public abstract class ApplicationConstants {

    /**
     * 用户登录session名称
     */
    public static final String LOGIN_SESSION_NAME = "userInfo";

    /**
     * 索引所有的session
     * 用于单一登录
     */
    public static Map<String,HttpSession> SESSION_MAP = new HashMap<>();

    /**
     * 当前在线用户数
     */
    public static int CURRENT_LOGIN_COUNT = 0;

    /**
     * 历史访客总数
     */
    public static int TOTAL_HISTORY_COUNT = 0;

    /**
     * 最高同时在线人数
     */
    public static int MAX_ONLINE_COUNT = 0;

    /**
     * 服务器启动时间
     */
    public static Date SERVER_START_DATE = new Date();

    /**
     * 最高在线人数时间
     */
    public static Date MAX_ONLINE_COUNT_DATE = new Date();



}