package com.boss.xtrain.user.utils;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author: moukex
 * @Description: 获取上下文的工具类
 * @Date: 2020/9/14 17:19
 * @Version: 1.0
 */

@Component
@Lazy(false)
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext APPLICATION_CONTEXT;
    /**
     * 设置spring上下文  *  * @param applicationContext spring上下文  * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATION_CONTEXT = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }
}

