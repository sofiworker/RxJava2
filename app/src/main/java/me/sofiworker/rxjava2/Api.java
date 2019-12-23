package me.sofiworker.rxjava2;

import io.reactivex.Observable;
import me.sofiworker.rxjava2.base.BaseData;
import me.sofiworker.rxjava2.bean.PageBean;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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
    @GET("article/list/{pageNum}/json")
    Observable<BaseData<PageBean>> getHomeArticleList(@Path("pageNum") int pageNum);
}
