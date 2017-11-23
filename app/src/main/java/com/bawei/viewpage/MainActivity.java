package com.bawei.viewpage;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements V_view{
private Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
 if (msg.what==0){
     int i = viewPager.getCurrentItem();
     i++;
     viewPager.setCurrentItem(i);
     handler.sendEmptyMessageDelayed(0,1000);
 }
    }
};
    private ViewPager viewPager;
    private List<Bean.RetBean.ListBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.vp);
        RadioButton radioButton1= (RadioButton) findViewById(R.id.but1);
        RadioButton radioButton2= (RadioButton) findViewById(R.id.but2);
        RadioButton radioButton3= (RadioButton) findViewById(R.id.but3);
        RadioButton radioButton4= (RadioButton) findViewById(R.id.but4);
        final RadioButton radioBs[]={radioButton1,radioButton2,radioButton3,radioButton4};
        Prenster prenster=new Prenster(this);
        prenster.prenst();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                int size = list.size();
                radioBs[position%radioBs.length].setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
      handler.sendEmptyMessage(0);
    }

    @Override
    public void getData(final Bean bean) {
      runOnUiThread(new Runnable() {
          @Override
          public void run() {
              list = bean.getRet().getList();
              viewPager.setAdapter(new Vpadapter(MainActivity.this, list));
          }
      });
    }
}
