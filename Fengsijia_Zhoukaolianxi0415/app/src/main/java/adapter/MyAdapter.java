package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

import bean.MyBean;
import fsj.bawei.com.fengsijia_zhoukaolianxi0415.R;

/**
 * author：冯思佳
 * data：2017/4/15 10:27
 * function：
 */

public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<MyBean.ResultBean.DateBean> list;

    public MyAdapter(Context context, List<MyBean.ResultBean.DateBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.list_item,null);
            holder=new ViewHolder();
            holder.tv= (TextView) convertView.findViewById(R.id.lv_tv);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position).getTitle());
        return convertView;
    }

    class ViewHolder{
        TextView tv;
    }
}
