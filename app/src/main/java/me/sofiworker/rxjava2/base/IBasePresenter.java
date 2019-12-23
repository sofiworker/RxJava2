package me.sofiworker.rxjava2.base;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/23 10:23
 * @description 基础presenter接口
 */
public interface IBasePresenter<T extends IBaseView> {

    void attachView(T view);

    void detachView();
}
