package fsj.bawei.com.app3_xutils;

import android.content.Context;
import android.os.Handler;
import android.util.Log;


import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;

import java.util.List;

import xlistview.bawei.com.xlistviewlibrary.XListView;


/**
 * date:2017/4/10 15:59
 * author: 冯思佳.
 * 类描述：
 */

public class MyXutils {

    private final Context context;
    private final XListView xlistview;
    private final Handler mHandler;

    public MyXutils(Context context, XListView xListView,Handler mHandler) {
        this.context = context;
        this.xlistview = xListView;
        this.mHandler = mHandler;
    }
    public void  DoGet(String str){
        RequestParams params = new RequestParams(Urls.mPath);
        params.addQueryStringParameter("uri",str);
        org.xutils.x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //Log.d("zzz", result.toString());
                //解析数据
                Gson gson = new Gson();
                NewsBean gjBean = gson.fromJson(result, NewsBean.class);
                List<NewsBean.ResultBean.DataBean> data = gjBean.getResult().getData();

                final MyAdapter myAdapter = new MyAdapter(context,data);
                xlistview.setAdapter(myAdapter);

                xlistview.setPullLoadEnable(true);//允许加载
                xlistview.setPullRefreshEnable(true);//允许刷新

                xlistview.setXListViewListener(new XListView.IXListViewListener() {
                    @Override
                    public void onRefresh() {
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                myAdapter.notifyDataSetChanged();
                                onLoad();
                            }
                        }, 2000);

                    }

                    @Override
                    public void onLoadMore() {
//                        mHandler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                myAdapter.notifyDataSetChanged();
//                                onLoad();
//                            }
//                        }, 2000);
                    }
                });

            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d("fff", "请求异常");
            }
            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {
                Log.d("fff", "取消请求");
            }
            @Override
            public void onFinished() {
            }
        });

        return ;
    }

    private void onLoad() {
        xlistview.stopRefresh();//停止刷新
        xlistview.stopLoadMore();//停止加载更多
        xlistview.setRefreshTime("刚刚");
    }
}
