package cn.suqc.listener;

import cn.suqc.util.ApplicationConstants;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * servletContext监听
 * 记录服务器信息 启动关闭时间等
 * @author LIUTIE
 *
 */
public class MyContextListener implements ServletContextListener {

    /**
     * 服务器启动时被调用
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        //记录启动时间
        ApplicationConstants.SERVER_START_DATE = new Date();
    }

    /**
     * 服务器关闭时被调用
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        //保存数据到硬盘
        // TODO Auto-generated method stub
    }

}