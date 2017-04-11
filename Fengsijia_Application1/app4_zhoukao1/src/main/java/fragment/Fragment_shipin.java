package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fsj.bawei.com.app4_zhoukao1.R;

/**
 * date:2017/4/10 20:23
 * author: 冯思佳.
 * 类描述：
 */

public class Fragment_shipin extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shipin,null);
        return v;
    }
}
