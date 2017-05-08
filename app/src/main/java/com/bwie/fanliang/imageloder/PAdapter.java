package com.bwie.fanliang.imageloder;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by fanliang on 2017/4/21.
 */

public class PAdapter extends PagerAdapter {
    Context context;
    List<ImageView> imageList;
    public PAdapter(Context context, List<ImageView> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = imageList.get(position);
        container.addView(imageList.get(position));
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(imageList.get(position));
    }
}
