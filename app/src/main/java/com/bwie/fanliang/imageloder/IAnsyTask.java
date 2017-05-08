package com.bwie.fanliang.imageloder;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by fanliang on 2017/4/20.
 */

public class IAnsyTask extends AsyncTask<Object,Integer,String> {
    private Handler handler;
    Map params;
    List<Bean.ListBean> list = new ArrayList<Bean.ListBean>();
    public IAnsyTask(Handler handler){
        this.handler = handler;

}


    @Override
    protected String doInBackground(Object... params) {
        String result;
       Map map = (Map) params[0];
        this.params = map;
    //   int page = (int) map.get("page");
       String path = "http://qhb.2dyt.com/Bwei/news";
   //     String postkey = (String) map.get("postkey");

        Ht
        tpClient client = new DefaultHttpClient();
      //  HttpGet get = new HttpGet(path);
        HttpPost post = new HttpPost(path);
       /* StringBuffer sb = new StringBuffer();
        try {
           Set<String> set =  map.keySet();
            for(String key : set){
            sb.append(key);
                sb.append("=");
                sb.append(map.get(key));
                sb.append("&");

            }
            sb.deleteCharAt(sb.length()-1);*/

        List<BasicNameValuePair>   list=new ArrayList<>();

        Set<String> set = map.keySet();

        for (String  s:set) {
            list.add(new BasicNameValuePair(s,map.get(s).toString()));
        }

        try {
            post.setEntity(new UrlEncodedFormEntity(list));
            HttpResponse response = (HttpResponse) client.execute(post);

            if(response.getStatusLine().getStatusCode() == 200){
                InputStream inputStream = response.getEntity().getContent();

               result = StringUtils.inputStreamToString(inputStream);

             //   System.out.println("result.toString() = ================" + result.toString());
                return result;
        }




        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Gson gson = new Gson();
        Bean bean = gson.fromJson(s,Bean.class);
        list.addAll(bean.getList());

        Message msg = Message.obtain();

        int page = (int)params.get("page");

        msg.what = page == 1 ? 1 : 2;
        //message.what = page == 1 ? 1 : 2 ;
        msg.obj = bean.getList();
        handler.sendMessage(msg);

    }
}
