package com.gorden5566.framework.spring.xml;

/**
 * 业务二：新闻数据持久化
 *
 * @author gorden5566
 * @date 2018/10/21
 */
public interface IFXNewsPersister {

    /**
     * 保存新闻数据
     *
     * @param newsBean 新闻内容
     */
    void persistNews(FXNewsBean newsBean);
}
