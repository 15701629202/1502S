package myImageLoader;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by lenovo on 2017/3/19.
 */

public class MyImageApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        initimageloader();
    }

    private void initimageloader() {
        //初始化imageloader
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(120,120).build();
        //初始化的时候添加配置
        ImageLoader.getInstance().init(configuration);
    }

}
