package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import org.xutils.x;

import java.util.List;

import bean.NewsBean;
import fsj.bawei.com.fengsijia_zhoukaolianxi0415.R;

/**
 * author：冯思佳
 * data：2017/4/15 10:59
 * function：
 */

public class MyMenuAdapter extends BaseAdapter{
    private Context context;
    List<NewsBean.ResultBean.DataBean> list;

    public MyMenuAdapter(Context context, List<NewsBean.ResultBean.DataBean> list) {
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
            convertView=View.inflate(context, R.layout.menu_item,null);
            holder=new ViewHolder();
            holder.iv= (ImageView) convertView.findViewById(R.id.menu_iv);
            holder.tv_title= (TextView) convertView.findViewById(R.id.menu_title);
            holder.tv_author= (TextView) convertView.findViewById(R.id.menu_author);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_author.setText(list.get(position).getAuthor_name());
        x.image().bind(holder.iv,list.get(position).getThumbnail_pic_s());
        return convertView;
    }

    class ViewHolder{
        ImageView iv;
        TextView tv_title,tv_author;
    }
}
