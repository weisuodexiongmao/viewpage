package com.bawei.viewpage;

/**
 * Created by 猥琐的熊猫 on 2017/11/23.
 */

public class Prenster {
    private V_view v_view;
    private Mod mod;
    public Prenster(V_view v_view) {
        this.v_view = v_view;
        this.mod=new Mod();
    }
    public void prenst(){
        mod.getData(new Mod.Data() {
            @Override
            public void shuju(Bean bean) {
                v_view.getData(bean);
            }
        });
    }
}
