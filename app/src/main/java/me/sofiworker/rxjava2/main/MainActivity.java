package me.sofiworker.rxjava2.main;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import me.sofiworker.rxjava2.R;
import me.sofiworker.rxjava2.base.BaseActivity;
import me.sofiworker.rxjava2.bean.ArticleBean;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {

    private static final String TAG = "MainActivity";
    @BindView(R.id.rv_main)
    RecyclerView mMainRv;

    private MainRvAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEvent() {

        mPresenter = new MainPresenter();
        mPresenter.attachView(this);

        mMainRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MainRvAdapter();
        mMainRv.setAdapter(mAdapter);
        mMainRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mPresenter.getHomeArticle();
    }

    @Override
    public void showArticleList(List<ArticleBean> articleList) {
        mAdapter.setNewData(articleList);
    }
}
