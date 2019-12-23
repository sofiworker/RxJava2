package me.sofiworker.rxjava2.base;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/23 10:22
 * @description 基础view
 */
public interface IBaseView {

    void showToastMsg(String msg);

    void showEmptyView();

    void showErrorView();

    void showLoadingView();

    void showNoNetWorkView();

    void showSuccessView();
}
