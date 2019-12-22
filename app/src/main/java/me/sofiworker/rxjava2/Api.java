package me.sofiworker.rxjava2;

import io.reactivex.Observable;
import me.sofiworker.rxjava2.bean.BaseData;
import me.sofiworker.rxjava2.bean.PageBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/22 22:37
 * @description
 */
public interface Api {

    /**
     * 获取主页文章
     * @return Observable<BaseData<PageBean>>
     */
    Observable<BaseData<PageBean>> getHomeArticleList();
}
