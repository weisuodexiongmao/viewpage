package com.bawei.viewpage;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 猥琐的熊猫 on 2017/11/23.
 */

public class Mod {
public void getData(final Data data){
    OkHttpClient okHttpClient=new OkHttpClient();
    Request request=new Request.Builder().url("http://api.svipmovie.com/front//columns/getVideoList.do?catalogId=402834815584e463015584e539330016").build();
    Call call = okHttpClient.newCall(request);
    call.enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String string = response.body().string();
            Gson gson=new Gson();
            Bean bean = gson.fromJson(string, Bean.class);
            data.shuju(bean);
        }
    });
}
interface Data{
    public void shuju(Bean bean);
}
}
