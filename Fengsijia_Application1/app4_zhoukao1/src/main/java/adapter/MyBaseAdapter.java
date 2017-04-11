package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.x;

import java.util.List;

import bean.NewsBean;
import fsj.bawei.com.app4_zhoukao1.R;

/**
 * date:2017/4/10 20:07
 * author: 冯思佳.
 * 类描述：
 */

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<NewsBean.ResultBean.DataBean> mList;

    public MyBaseAdapter(Context context, List<NewsBean.ResultBean.DataBean> list) {
        this.context = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.xlv_item_layout, null);
            holder = new viewHolder();

            holder.t1 = (TextView) convertView.findViewById(R.id.text_v1);
            holder.t2 = (TextView) convertView.findViewById(R.id.text_v2);
            holder.iv = (ImageView) convertView.findViewById(R.id.image_v);
            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();
        }
        //x.image().bind(holder.iv,mList.get(position).getThumbnail_pic_s());
        ImageLoader.getInstance().displayImage(mList.get(position).getThumbnail_pic_s(),holder.iv);
        holder.t1.setText(mList.get(position).getTitle());
        holder.t2.setText(mList.get(position).getAuthor_name());

        return convertView;

    }
    class viewHolder{
        ImageView iv;
        TextView t1,t2;
    }
}
