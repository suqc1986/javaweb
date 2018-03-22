package cn.suqc.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * request监听 用于记录客户信息 ip、url等
 *
 * @author LIUTIE
 *
 */
public class MyRequestListener implements ServletRequestListener {

    /**
     * request销毁时调用
     */
    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        // TODO Auto-generated method stub

    }

    /**
     * request创建时调用
     */
    @Override
    public void requestInitialized(ServletRequestEvent event) {
        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        // 客户端ip
        String ip = request.getRemoteAddr();
        // 访问的URL地址
        String url = request.getRequestURI();
        // 只做简单后台打印
        System.out.println("The client ip is " + ip);
        System.out.println("The address url is " + url);
    }

}