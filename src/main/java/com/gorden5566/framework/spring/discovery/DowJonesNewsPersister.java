package com.gorden5566.framework.spring.discovery;

/**
 * @author gorden5566
 * @date 2018/10/21
 */
public class DowJonesNewsPersister implements IFXNewsPersister {
    @Override
    public void persistNews(FXNewsBean newsBean) {
        System.out.println("newsBean = " + newsBean);
    }
}
