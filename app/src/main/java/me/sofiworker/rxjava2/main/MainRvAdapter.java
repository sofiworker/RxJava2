package me.sofiworker.rxjava2.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.sofiworker.rxjava2.R;
import me.sofiworker.rxjava2.bean.ArticleBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/22 23:28
 * @description 主页rv适配器
 */
public class MainRvAdapter extends RecyclerView.Adapter<MainRvAdapter.ViewHolder> {

    private static final String TAG = "MainRvAdapter";

    private List<ArticleBean> mList;

    public void setNewData(List<ArticleBean> list){
        this.mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main_rv, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        int position = viewHolder.getAdapterPosition();
        ArticleBean bean = mList.get(position);
        viewHolder.mTitleTv.setText(bean.getTitle());
        viewHolder.mAuthorTv.setText(bean.getAuthor());
        String str = bean.getSuperChapterName()+"/"+bean.getChapterName();
        viewHolder.mCategoryTv.setText(str);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView mTitleTv;
        @BindView(R.id.tv_author)
        TextView mAuthorTv;
        @BindView(R.id.tv_category)
        TextView mCategoryTv;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
