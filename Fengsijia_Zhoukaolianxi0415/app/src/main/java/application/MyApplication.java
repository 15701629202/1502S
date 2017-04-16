package application;

import android.app.Application;

import org.xutils.x;

/**
 * date:2017/4/15 10:36
 * author: 冯思佳.
 * 类描述：
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false); //输出debug日志，开启会影响性能

    }

}
