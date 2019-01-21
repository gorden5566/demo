package com.gorden5566.demos.spring;

/**
 * @author renjianjun02
 * @date 2018/10/21
 */
public interface IFXNewsListener {

    String[] getAvailableNewsIds();

    FXNewsBean getNewsByPK(String newsId);

    void postProcessIfNecessary(String newsId);
}
