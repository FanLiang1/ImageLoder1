package com.bwie.fanliang.imageloder;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by fanliang on 2017/4/20.
 */


public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Bean.ListBean> list;
    public MyAdapter(Context context, List<Bean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {

        if(list.get(position).getType()==1){
            return 0;
        }else{
            return 1;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Vh1 vh1 = null;
        Vh2 vh2 = null;

        int type = getItemViewType(position);
        if(convertView == null){
            if(type==0){
                vh1 = new Vh1();
                convertView = convertView.inflate(context, R.layout.layout1,null);
                vh1.tv1 = (TextView) convertView.findViewById(R.id.layout1_title);
                vh1.tv2 = (TextView) convertView.findViewById(R.id.layout1_foot);
                vh1.iv1 = (ImageView) convertView.findViewById(R.id.layout1_iv);
                convertView.setTag(vh1);
            }else{
                vh2 = new Vh2();
                convertView = convertView.inflate(context,R.layout.layout2,null);
                vh2.tv1 = (TextView) convertView.findViewById(R.id.layout2_title);
                vh2.iv1 = (ImageView) convertView.findViewById(R.id.layout2_iv1);
                vh2.iv2 = (ImageView) convertView.findViewById(R.id.layout2_iv2);
                vh2.iv3 = (ImageView) convertView.findViewById(R.id.layout2_iv3);
                vh2.tv2 = (TextView) convertView.findViewById(R.id.layout2_foot);
                convertView.setTag(vh2);
            }

        }else{

            if(type == 0){
                vh1 = (Vh1) convertView.getTag();
            }else{
                vh2 = (Vh2) convertView.getTag();
            }

        }
        if(type == 0){
            vh1.tv1.setText(list.get(position).getTitle());
            vh1.tv2.setText(list.get(position).getDate());
            ImageLoader.getInstance().displayImage(list.get(position).getPic(),vh1.iv1,Ipplication.getOption());
        }else{
            vh2.tv1.setText(list.get(position).getTitle());

            String[] arr = list.get(position).getPic().split("\\|");
            ImageLoader.getInstance().displayImage(arr[0],vh2.iv1,Ipplication.getOption());
            ImageLoader.getInstance().displayImage(arr[1],vh2.iv2,Ipplication.getOption());
            ImageLoader.getInstance().displayImage(arr[2],vh2.iv3,Ipplication.getOption());
            vh2.tv2.setText(list.get(position).getDate());
        }



       // vh1.tv1.setText(list.get(position));
        return convertView;
    }
    class Vh1{
        TextView tv1;
        TextView tv2;
        ImageView iv1;
    }

    class Vh2{
        TextView tv1;
        ImageView iv1;
        ImageView iv2;
        ImageView iv3;
        TextView tv2;

    }

}
