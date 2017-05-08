package com.bwie.fanliang.imageloder;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.Switch;

import com.bwie.fanliang.xlistview.XListView;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements XListView.IXListViewListener{

   // private XListView xListView;
    private List<Bean.ListBean> list = new ArrayList<Bean.ListBean >();
    List<ImageView> ImageList = new ArrayList<ImageView>();
    String[] images = {"http://www.iyi8.com/uploadfile/2017/0409/20170409111824306.jpg",
    "http://www.iyi8.com/uploadfile/2014/0606/20140606104707928.jpg",
    "http://www.iyi8.com/uploadfile/2014/0204/20140204094009487.jpg"};

    //List<String> list = new ArrayList<String>();
    private int page = 1;
    MyHandler handler = new MyHandler(this);
    private MyAdapter adapter;
    private PAdapter padapter;
    private XListView xListView;

    static class MyHandler extends Handler{
        WeakReference<MainActivity> weakReference;
        public  MyHandler(MainActivity mainActivity){
            weakReference = new WeakReference<MainActivity>(mainActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
           MainActivity activity =  weakReference.get();
            if(activity == null){
                return;
            }
            switch(msg.what){
                case 1:
                    List<Bean.ListBean> listBean = (List<Bean.ListBean>)msg.obj;
                    activity.udpate((List<Bean.ListBean>)msg.obj ,1);
                  //  activity.udpate(listBean);
                        break;
                case 2:
                   // List<Bean.ListBean> listBean = (List<Bean.ListBean>)msg.obj;
                    activity.udpate((List<Bean.ListBean>)msg.obj,2);
                    break;
            }
        }
    }
    //aksdjfjaklsdjfkla
//范亮亮
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //com.bwie.fanliang.xlistview.R
        //com.bwie.fanliang.xlistview.R

        xListView = (XListView) findViewById(R.id.main_xListView);
       // ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
      //  createPoint();
       // padapter = new PAdapter(MainActivity.this,ImageList);
       // viewPager.setAdapter(padapter);

//dasasdfasf
        adapter = new MyAdapter(MainActivity.this,list);
        xListView.setAdapter(adapter);
      //  new MyAsncTask().execute("http://api.expoon.com/AppNews/getNewsList/type/1/p/1");
        xListView.setXListViewListener(this);
        xListView.setPullRefreshEnable(true);
        xListView.setPullLoadEnable(true);
        getData(page);

    }

    private void createPoint() {
        for (int i = 0;i<images.length;i++){
            ImageView iv = new ImageView(this);
            ImageList.add(iv);
            ImageLoader.getInstance().displayImage(images[i],iv);

        }

    }

    public void udpate(List<Bean.ListBean> listBean,int type){

        if(type == 1){
            list.clear();
            list.addAll(listBean);
            adapter.notifyDataSetChanged();
            xListView.stopRefresh();
            xListView.setRefreshTime("刚刚");
        }else{
            list.addAll(listBean);
            adapter.notifyDataSetChanged();
            xListView.stopLoadMore();
        }
    }

    public void getData(int page) {
        Map map = new HashMap();
        map.put("type",2);
        map.put("page",page);
        // map.put("url","http://qhb/2dyt.com/Bwei.news");
        map.put("postkey","1503d");

        new IAnsyTask(handler).execute(map);
    }

    @Override
    public void onRefresh() {
        page = 1;
        getData(page);

    }

    @Override
    public void onLoadMore() {
        page = page+1;
        getData(page);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
    /* class MyAsncTask extends AsyncTask<String,Integer,String>{

        private String result;

        @Override
        protected String doInBackground(String... params) {
            String path = params[0];

            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(path);
            try {
                HttpResponse response = (HttpResponse) client.execute(get);
                if(response.getStatusLine().getStatusCode() == 200){
                    InputStream inputStream = response.getEntity().getContent();
                    result = StringUtils.inputStreamToString(inputStream);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }*/
}
