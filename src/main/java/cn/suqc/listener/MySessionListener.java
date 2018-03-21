package cn.suqc.listener;

import cn.suqc.util.ApplicationConstants;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听
 * 记录登录信息 访问总人数 在线人数等
 * 实现单一登录
 * @author LIUTIE
 *
 */
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * session创建时被调用
     */
    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        // 获取创建的session
        HttpSession session = sessionEvent.getSession();
        // 添加到map
        ApplicationConstants.SESSION_MAP.put(session.getId(), session);
        // 访问总人数++
        ApplicationConstants.TOTAL_HISTORY_COUNT++;
        // 如果map总数大于最高同时在线人数则更新最高在线人数及时间
        if (ApplicationConstants.MAX_ONLINE_COUNT < ApplicationConstants.SESSION_MAP.size()) {
            ApplicationConstants.MAX_ONLINE_COUNT = ApplicationConstants.SESSION_MAP.size();
            ApplicationConstants.MAX_ONLINE_COUNT_DATE = new Date();
        }

    }

    /**
     * session销毁时被调用
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        // 获取即将被销毁的session
        HttpSession session = sessionEvent.getSession();
        // 在map中根据key移除
        ApplicationConstants.SESSION_MAP.remove(session.getId());
    }

    /**
     * 添加session属性时被调用
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // 判断是否添加的用户登录信息session
        if (event.getName().equals(ApplicationConstants.LOGIN_SESSION_NAME)) {
            // 当前登录用户数++
            ApplicationConstants.CURRENT_LOGIN_COUNT++;
            // 是否在其他机器登录处理
            isLoginInOtherPlace(event);
        }
    }

    /**
     * 移除session属性时被调用
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        // 判断是否移除的用户登录信息session
        if (event.getName().equals(ApplicationConstants.LOGIN_SESSION_NAME)) {
            // 当前登录用户数--
            ApplicationConstants.CURRENT_LOGIN_COUNT--;
            // 是否在其他机器登录处理
            isLoginInOtherPlace(event);
        }
    }

    /**
     * 修改session属性时被调用
     */
    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

        // 判断是否修改的用户登录信息session
        if (event.getName().equals(ApplicationConstants.LOGIN_SESSION_NAME)) {
            // 是否在其他机器登录处理
            isLoginInOtherPlace(event);
        }
    }

    /**
     * 是否在其他机器登录处理
     *
     * @param event
     */
    private void isLoginInOtherPlace(HttpSessionBindingEvent event) {
        // 获取添加的session
        HttpSession session = event.getSession();
        // 遍历查找此用户是否登录
        for (HttpSession s : ApplicationConstants.SESSION_MAP.values()) {
            // 如果已经在其他机器登录则使其失效
            if (event.getValue().equals(s.getAttribute(ApplicationConstants.LOGIN_SESSION_NAME))
                    && session.getId() != s.getId()) {
                // 使session失效
                session.invalidate();
                break;
            }
        }
    }
}