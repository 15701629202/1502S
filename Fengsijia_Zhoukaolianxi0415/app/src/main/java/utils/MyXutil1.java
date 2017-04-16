package utils;

import android.content.Context;
import android.widget.ListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import adapter.MyAdapter;
import bean.MyBean;

/**
 * author：冯思佳
 * data：2017/4/15 10:13
 * function：
 */

public class MyXutil1 {
    private Context context;
    private ListView lv;
    public List<MyBean.ResultBean.DateBean> mDateBeanList;

    public MyXutil1(Context context, ListView lv) {
        this.context = context;
        this.lv = lv;
    }

    public void showLst(String uri){
        RequestParams params=new RequestParams(Utils.path1);
        params.addQueryStringParameter("uri",uri);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                MyBean bean = GsonUtil.getBean(result, MyBean.class);
                mDateBeanList = bean.getResult().getDate();
                lv.setAdapter(new MyAdapter(context, mDateBeanList));
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
