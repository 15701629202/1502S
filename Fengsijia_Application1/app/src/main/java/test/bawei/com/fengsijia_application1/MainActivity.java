package test.bawei.com.fengsijia_application1;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import utils.MyAsyncTask;
import utils.Url;

/**
 *
 */

public class MainActivity extends AppCompatActivity {

    private TextView title01;
    private ListView lv;
    private RelativeLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        MyAsyncTask asynTast = new MyAsyncTask(this,lv);
        asynTast.execute(Url.path);
    }

    private void initView() {
        title01 = (TextView) findViewById(R.id.title01);
        lv = (ListView) findViewById(R.id.lv);
    }
}
