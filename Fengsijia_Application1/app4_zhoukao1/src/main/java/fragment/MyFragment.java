package fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adapter.MyBaseAdapter;
import fsj.bawei.com.app4_zhoukao1.R;
import xlistview.bawei.com.xlistviewlibrary.XListView;
import xutils.MyXUtils;

/**
 * date:2017/4/10 18:59
 * author: 冯思佳.
 * 类描述：
 */

public class MyFragment extends Fragment {


    private View mV;
    private XListView mXlv;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    public static MyFragment getFragment(String uri){
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url",uri);
        myFragment.setArguments(bundle);
        return myFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mV = inflater.inflate(R.layout.fragment_xlv_layout,null);
        return mV;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        Bundle arguments = getArguments();
        String s = arguments.getString("url");
        MyXUtils myxutils = new MyXUtils(getActivity(),mXlv,handler);
        myxutils.DoGet(s);
    }

    private void initView() {
        mXlv = (XListView) mV.findViewById(R.id.xlv);
    }
}
