package me.sofiworker.rxjava2.main;

import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.sofiworker.rxjava2.App;
import me.sofiworker.rxjava2.base.BaseData;
import me.sofiworker.rxjava2.base.BaseObserver;
import me.sofiworker.rxjava2.base.BasePresenter;
import me.sofiworker.rxjava2.bean.ArticleBean;
import me.sofiworker.rxjava2.bean.PageBean;
import me.sofiworker.rxjava2.util.RxUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/23 10:18
 * @description p层
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter{

    @Override
    public void getHomeArticle() {
        addRequest(mApi.getHomeArticleList(1)
                .compose(RxUtil.schedulerTransformer())
                .subscribeWith(new BaseObserver<PageBean>(mView) {
            @Override
            public void onSuccess(PageBean data) {
                mView.showArticleList(data.getDatas());
            }}));
    }
}
