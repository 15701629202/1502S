package adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/22.
 * 此方法是封装了viewpager的无限轮播
 */

public class MyPagerAdapter extends PagerAdapter {
    /**
     * 定义成员变量通过构造方法进行值的互传
     */
    private Context context;
    private List<String> path;
   private List<View> imglist=new ArrayList<View>();
    public MyPagerAdapter(Context context, List<String> path) {
        this.context = context;
        this.path = path;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //自定义一个imageview
        ImageView imageView = new ImageView(context);
        //调用imageloader给他路径和控件显示
        ImageLoader.getInstance().displayImage(path.get(position%path.size()),imageView);
        //判断他的长度是否等于集合的长度如果等于就给他删除
        if (container.getChildCount() == path.size()) {
            container.removeView(imageView);
        }
        //把每次创建的控件添加到自定义的list集合中
        imglist.add(imageView);
        //添加到视图上
        container.addView(imageView);
        //返回一个视图
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(imglist.get(position%imglist.size()));
    }
}
