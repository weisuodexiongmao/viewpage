package com.bawei.viewpage;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 猥琐的熊猫 on 2017/11/23.
 */

public class Vpadapter extends PagerAdapter {
    private Context context;
    private List<Bean.RetBean.ListBean>listBeen;

    public Vpadapter(Context context, List<Bean.RetBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        SimpleDraweeView simpleDraweeView= (SimpleDraweeView) view.findViewById(R.id.sdv);
        simpleDraweeView.setImageURI(listBeen.get(position%listBeen.size()).getPic());
        simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
