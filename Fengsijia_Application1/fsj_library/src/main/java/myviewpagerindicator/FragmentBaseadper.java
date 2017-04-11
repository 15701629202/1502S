package myviewpagerindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lenovo on 2017/3/27.
 */

public class FragmentBaseadper extends FragmentPagerAdapter {
private List<String> list;

    public FragmentBaseadper(FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {

        return TextFragment.newInstance(list.get(position%list.size()));

    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return data[position%data.length].toUpperCase();
//        return list.get(position%list.size()).getName().toString();
        return list.get(position).toUpperCase();
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
