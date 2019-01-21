package com.gorden5566.framework.spring.discovery;

/**
 * @author gorden5566
 * @date 2018/10/21
 */
public class DowJonesNewsListener implements IFXNewsListener {
    @Override
    public String[] getAvailableNewsIds() {
        return new String[]{"1001"};
    }

    @Override
    public FXNewsBean getNewsByPK(String newsId) {
        return new FXNewsBean();
    }

    @Override
    public void postProcessIfNecessary(String newsId) {

    }
}
