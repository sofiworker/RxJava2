package me.sofiworker.rxjava2.base;

import android.util.Log;

import io.reactivex.observers.ResourceObserver;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/23 10:04
 * @description observer的封装
 */
public abstract class BaseObserver<T> extends ResourceObserver<BaseData<T>> {

    private IBaseView mView;

    public BaseObserver(IBaseView view){
        this.mView = view;
    }

    @Override
    protected void onStart() {
        mView.showLoadingView();
        super.onStart();
    }


    @Override
    public void onNext(BaseData<T> baseData) {
        if (baseData.getErrorCode() == 0){
            onSuccess(baseData.getData());
            mView.showSuccessView();
        }else {
            mView.showErrorView();
        }
    }

    @Override
    public void onError(Throwable e) {
        mView.showErrorView();
        mView.showToastMsg(e.getMessage());
    }

    @Override
    public void onComplete() {
    }

    public abstract void onSuccess(T data);
}
