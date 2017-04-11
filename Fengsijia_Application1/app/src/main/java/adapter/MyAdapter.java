package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bean.CarBean;
import test.bawei.com.fengsijia_application1.R;

/**
 * date:2017/4/7 22:08
 * author: 冯思佳.
 * 类描述：设置适配器
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private  List<CarBean.ListBean> list;


    public MyAdapter(Context context, List<CarBean.ListBean> list) {
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
        viewHolder holder;
        if (convertView ==null){
            convertView = View.inflate(context,R.layout.lv_item_layout,null);
            holder = new viewHolder();

            holder.t1 = (TextView) convertView.findViewById(R.id.text_name);
            holder.t2 = (TextView) convertView.findViewById(R.id.text_place);
            convertView.setTag(holder);
        }else {
            holder = (viewHolder) convertView.getTag();
        }
        holder.t1.setText(list.get(position).getSite_name());
        holder.t2.setText(list.get(position).getAddress());
        return convertView;
    }
    class viewHolder{
        TextView t1,t2;
    }
}
