package me.sofiworker.rxjava2.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.sofiworker.rxjava2.AbstractUiLoader;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/23 10:19
 * @description 基础活动
 */
public abstract class BaseActivity<T extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    protected T mPresenter;
    private Toast mToast;
    private AbstractUiLoader mUiLoader;
    private Unbinder mUnBinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mUiLoader == null) {
            mUiLoader = new AbstractUiLoader(this) {
                @Override
                public View getSuccessView(ViewGroup container) {
                    return LayoutInflater.from(getContext()).inflate(getLayoutId(), container, false);
                }
            };
        }
        mUiLoader.setStatus(AbstractUiLoader.Status.SUCCESS);
        setContentView(mUiLoader);
        mUnBinder = ButterKnife.bind(this);

        initEvent();
    }

    protected abstract int getLayoutId();

    protected abstract void initEvent();

    @Override
    public void showToastMsg(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
            mToast.show();
        }else {
            mToast.setText(msg);
            mToast.show();
        }
    }

    @Override
    public void showEmptyView() {
        mUiLoader.setStatus(AbstractUiLoader.Status.EMPTY);
    }

    @Override
    public void showErrorView() {
        mUiLoader.setStatus(AbstractUiLoader.Status.ERROR);
    }

    @Override
    public void showLoadingView() {
        mUiLoader.setStatus(AbstractUiLoader.Status.LOADING);
    }

    @Override
    public void showNoNetWorkView() {
        mUiLoader.setStatus(AbstractUiLoader.Status.NO_NETWORK);
    }

    @Override
    public void showSuccessView() {
        mUiLoader.setStatus(AbstractUiLoader.Status.SUCCESS);
    }

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroy();
    }
}
