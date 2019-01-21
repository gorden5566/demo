package com.gorden5566.framework.spring.discovery;

/**
 * @author renjianjun02
 * @date 2018/10/21
 */
public class FXNewsProvider {
    private IFXNewsListener newsListener;
    private IFXNewsPersister newPersistener;

    public FXNewsProvider() {
    }

    public FXNewsProvider(IFXNewsListener newsListener, IFXNewsPersister newPersistener) {
        this.newsListener = newsListener;
        this.newPersistener = newPersistener;
    }

    public void getAndPersistNews() {
        String[] newsIds = newsListener.getAvailableNewsIds();

        if (newsIds == null || newsIds.length == 0) {
            return;
        }

        for (String newsId : newsIds) {
            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newPersistener.persistNews(newsBean);
            newsListener.postProcessIfNecessary(newsId);
        }
    }

    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public void setNewPersistener(IFXNewsPersister newPersistener) {
        this.newPersistener = newPersistener;
    }
}
