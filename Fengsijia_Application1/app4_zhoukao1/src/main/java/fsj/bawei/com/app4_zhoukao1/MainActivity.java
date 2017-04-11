package fsj.bawei.com.app4_zhoukao1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import fragment.Fragment_guanzhu;
import fragment.Fragment_login;
import fragment.Fragment_shipin;
import fragment.Fragment_shouye;

public class MainActivity extends AppCompatActivity {
private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addFragment(new Fragment_shouye());//默认添加Fragment
    }



    private void initView() {
        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        Fragment_shouye f1 = new Fragment_shouye();
                        addFragment(f1);
                        break;
                    case R.id.rb2:
                        Fragment_shipin f2 = new Fragment_shipin();
                        addFragment(f2);
                        break;
                    case R.id.rb3:
                        Fragment_guanzhu f3 = new Fragment_guanzhu();
                        addFragment(f3);
                        break;
                    case R.id.rb4:
                        Fragment_login f4 = new Fragment_login();
                        addFragment(f4);
                        break;
                }
            }
        });
    }
    //动态添加Fragment
    private void addFragment(Fragment f) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frameLayout,f);
        transaction.commit();
    }
}
