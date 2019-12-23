package me.sofiworker.rxjava2.main;

import java.util.List;

import me.sofiworker.rxjava2.base.IBasePresenter;
import me.sofiworker.rxjava2.base.IBaseView;
import me.sofiworker.rxjava2.bean.ArticleBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/23 11:09
 * @description 契约接口
 */
public interface MainContract {

    interface View extends IBaseView {
        void showArticleList(List<ArticleBean> articleList);
    }

    interface Presenter extends IBasePresenter<View> {
        void getHomeArticle();
    }
}
