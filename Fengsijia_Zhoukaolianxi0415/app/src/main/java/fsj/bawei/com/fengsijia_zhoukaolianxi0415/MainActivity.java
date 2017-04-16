package fsj.bawei.com.fengsijia_zhoukaolianxi0415;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import utils.MyXutil1;
import utils.MyXutil2;


public class MainActivity extends AppCompatActivity {
    private ListView mLv;
    private SlidingMenu mMenu;
    private ListView mMenulv;
    private MyXutil1 mMyXutil1;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mMyXutil1 = new MyXutil1(this, mLv);
        mMyXutil1.showLst("news");
        initMenu();

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMenu.showMenu();
                mTv.setText(mMyXutil1.mDateBeanList.get(position).getTitle());
                new MyXutil2(MainActivity.this,mMenulv).showList(mMyXutil1.mDateBeanList.get(position).getUri());
            }
        });
    }


    private void initMenu() {
//获得屏幕宽度
        int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        int width = screenWidth / 6;
        mMenu = new SlidingMenu(this);
        mMenu.setMode(SlidingMenu.RIGHT);
        // 设置触摸屏幕的模式
        mMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置滑动菜单视图的宽度
        mMenu.setBehindOffset(width);
        // 设置渐入渐出效果的值
        mMenu.setFadeDegree(0.35f);
        mMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //设置必须在边缘滑动才能实现侧拉
        mMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        //为侧滑菜单设置布局
        mMenu.setMenu(R.layout.menu_layout);
        //得到侧滑菜单上的ListView和TextView
        mMenulv = (ListView) findViewById(R.id.menu_lv);
        mTv = (TextView) findViewById(R.id.newstitle);
    }

    private void initView() {
        mLv = (ListView) findViewById(R.id.lv);
    }



}
