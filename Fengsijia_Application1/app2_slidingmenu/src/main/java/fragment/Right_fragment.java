package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.bawei.com.app2_slidingmenu.R;

/**
 * date:2017/4/8 10:34
 * author: 冯思佳.
 * 类描述：
 */

public class Right_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.right_menu,null);
        return v;
    }
}
