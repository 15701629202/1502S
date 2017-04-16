package utils;

import android.content.Context;
import android.widget.ListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import adapter.MyMenuAdapter;
import bean.NewsBean;

/**
 * author：冯思佳
 * data：2017/4/15 10:52
 * function：
 */

public class MyXutil2 {
    private Context context;
    private ListView listView;

    public MyXutil2(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    public void showList(String uri){
        RequestParams params=new RequestParams(Utils.path2);
        params.addQueryStringParameter("uri",uri);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                NewsBean bean = GsonUtil.getBean(result, NewsBean.class);
                List<NewsBean.ResultBean.DataBean> dataBeanList = bean.getResult().getData();
                listView.setAdapter(new MyMenuAdapter(context,dataBeanList));
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
