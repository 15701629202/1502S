package myImageLoader;


import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * Created by lenovo on 2017/3/17.
 */

public class ImageLoaderOplicationutils {
    public static DisplayImageOptions getOption(int imgId){
        DisplayImageOptions options=new DisplayImageOptions.Builder().
                showImageOnLoading(imgId).showImageForEmptyUri(imgId).build();
        return options;
    }
}
