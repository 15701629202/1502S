package myTimedtat;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by lenovo on 2017/3/19.
 * 封装的倒计时方法类
 */

public class MyTime extends CountDownTimer {
    //定义一个textview用构造方法传递
    private TextView text;
    public MyTime(long millisInFuture, long countDownInterval,TextView text) {
        super(millisInFuture, countDownInterval);
        this.text=text;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        //把里面的变量转换成int型的变量并除以1000
        int s =Integer.parseInt(""+millisUntilFinished/1000);
        //定义转换算式
        int N=s/3600;
        s=s%3600;
        int K=s/60;
        s=s%60;
        int M=s;
        text.setText("剩余时间："+N+": "+K+":"+M+"");
    }

    /**
     * 如果想实现跳转的话就在onFinish（）方法中定义跳转
     */
    @Override
    public void onFinish() {
        text.setText("finish");
        //实现跳转
//        Intent intext=new Intent(context,TwoActivity.class);
//        context.starActivity();
    }
}
