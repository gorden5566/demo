package com.gorden5566.framework.spring.discovery;

/**
 * @author gorden5566
 * @date 2018/10/21
 */
public interface IFXNewsListener {

    String[] getAvailableNewsIds();

    FXNewsBean getNewsByPK(String newsId);

    void postProcessIfNecessary(String newsId);
}
