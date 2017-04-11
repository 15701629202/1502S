package fsj.bawei.com.app3_xutils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * date:2017/4/10 21:18
 * author: 冯思佳.
 * 类描述：
 */

public class MyVPAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList;
    private String[] title;

    public MyVPAdapter(FragmentManager fm, List<Fragment> list, String[] title) {
        super(fm);
        mList = list;
        this.title = title;
    }

    public MyVPAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
