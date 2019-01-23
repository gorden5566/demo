package com.gorden5566.framework.spring.xml;

/**
 * 业务一：获取新闻数据
 *
 * @author gorden5566
 * @date 2018/10/21
 */
public interface IFXNewsListener {

    /**
     * 获取所有新闻id
     *
     * @return
     */
    String[] getAvailableNewsIds();

    /**
     * 根据id获取新闻内容
     *
     * @param newsId
     * @return
     */
    FXNewsBean getNewsByPK(String newsId);

    /**
     * 后续处理
     *
     * @param newsId
     */
    void postProcessIfNecessary(String newsId);
}
