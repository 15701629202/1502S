package weizhen.bawei.com.lenovo.gwz_library;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lenovo on 2017/3/17.
 */

public class MyHttpURLConnection extends Thread{
    private Handler handler;
    private String url;
//    String jilu="";


    public MyHttpURLConnection(Handler handler, String url) {
        this.handler = handler;
        this.url = url;
    }

    @Override
    public void run() {
        super.run();
        String s = doGet(url);
        Message message = new Message();
        message.what=1;
        message.obj=s;
        handler.sendMessage(message);

    }
    public String doGet(String url){
        HttpURLConnection httpURLConnection=null;
        try {
            //得到路径
            URL url1 = new URL(url);
            //获取链接
            httpURLConnection = (HttpURLConnection) url1.openConnection();
            //定义获取请求的方式为get请求
            httpURLConnection.setRequestMethod("GET");
            //定义一个编码集格式
            httpURLConnection.setRequestProperty("encoding","gbk");
            //定义网络链接耗时的时间
            httpURLConnection.setConnectTimeout(5000);
            //定义网络读取耗时的时间
            httpURLConnection.setReadTimeout(5000);
            //获取网路的链接请求码
            int responseCode = httpURLConnection.getResponseCode();
            //对请求码进行判断
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
//              BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
//                String len;
                ByteArrayOutputStream boas = new ByteArrayOutputStream();
                byte[] byt=new byte[1024];
                int len=0;
//                while ((len=br.readLine())!=null){
//                    jilu+="/n"+len;
//                }
//                br.close();
                while ((len=inputStream.read(byt))!=-1){
                    boas.write(byt,0,len);
                }
                boas.close();
                return boas.toString("gbk");
            }else {
                Log.d("zzzz","请求失败！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ( httpURLConnection!= null) {
                //释放资源！！
                httpURLConnection.disconnect();
            }
        }
        return "解析失败！！！";
    }
   
}
