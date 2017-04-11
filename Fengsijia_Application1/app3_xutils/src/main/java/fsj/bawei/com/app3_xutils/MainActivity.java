package fsj.bawei.com.app3_xutils;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private List<Fragment> list = new ArrayList<Fragment>();
    private String[] titleArr = new String[]{"头条","国际","时尚","财经","国内","体育","娱乐","科技","社会","军事"};
    private TabLayout mTab;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);

        initView();
        initData();
    }

    private void initData() {
        mTab.setTabMode(TabLayout.MODE_SCROLLABLE);

        list.add(MyFragment.getFragment("tt"));
        list.add(MyFragment.getFragment("gj"));
        list.add(MyFragment.getFragment("ss"));
        list.add(MyFragment.getFragment("cj"));
        list.add(MyFragment.getFragment("gn"));
        list.add(MyFragment.getFragment("ty"));
        list.add(MyFragment.getFragment("yl"));
        list.add(MyFragment.getFragment("kj"));
        list.add(MyFragment.getFragment("shehui"));
        list.add(MyFragment.getFragment("js"));

        mTab.setTabTextColors(Color.BLACK,Color.RED);// tab被选中后，文字的颜色
        mTab.setupWithViewPager(mVp);

        mVp.setAdapter(new MyVPAdapter(getSupportFragmentManager(),list,titleArr));

        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
              mTab.setTabTextColors(Color.BLACK,Color.RED);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView(){
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tabl);
    }
}
