package com.hwoss.service;

/**
 * @author admin
 * @since     
 */
public interface IConfigService {

    /**
     * 获取全局配置
     *
     * @return {@link String}
     */
    String getGlobalConfig();

    /**
     * 获取用户配置
     *
     * @return {@link String}
     */
    String getUserConfig();
}
