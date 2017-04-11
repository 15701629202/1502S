package utils;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import adapter.MyAdapter;
import bean.CarBean;

/**
 * date:2017/4/7 21:34
 * author: 冯思佳.
 * 类描述：异步请求网络数据 设置适配器实现吐司删除功能
 */

public class MyAsyncTask extends AsyncTask<String,Integer,String> {
    private Context context;
    private ListView mListView;
    private MyAdapter mAdapter;

    public MyAsyncTask(Context context, ListView listView) {
        this.context = context;
        mListView = listView;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection httpURLConnectior= (HttpURLConnection) url.openConnection();
            httpURLConnectior.setConnectTimeout(5000);
            httpURLConnectior.setReadTimeout(5000);
            httpURLConnectior.setRequestMethod("GET");
            int responseCode = httpURLConnectior.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnectior.getInputStream();
                ByteArrayOutputStream boa = new ByteArrayOutputStream();
                byte[] byt=new byte[1024];
                int len=0;
                while ((len=inputStream.read(byt))!=-1){
                    boa.write(byt,0,len);
                }
                boa.close();
                inputStream.close();
                return boa.toString("UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Gson gson = new Gson();
        CarBean carBean = gson.fromJson(s, CarBean.class);
        final List<CarBean.ListBean> list = carBean.getList();

        final MyAdapter adapter = new MyAdapter(context,list);
        mListView.setAdapter(adapter);
        //点击某个租赁点item吐司（Toast）该租赁点id（json属性：id）
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "你点击了"+list.get(position).getId(), Toast.LENGTH_SHORT).show();
            }
        });
        //设置长按事件,并删除对应的条目，并展示剩余条目
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
             list.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(context, "你已经成功删除了一条数据", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
