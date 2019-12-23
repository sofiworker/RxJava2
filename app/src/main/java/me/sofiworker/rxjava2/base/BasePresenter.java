package me.sofiworker.rxjava2.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import me.sofiworker.rxjava2.Api;
import me.sofiworker.rxjava2.util.RetrofitUtil;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/23 11:14
 * @description 基础presenter
 */
public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

    protected T mView;
    private CompositeDisposable mCompositeDisposable;
    protected Api mApi = RetrofitUtil.getApi();

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    protected void addRequest(Disposable disposable){
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }
}
