package com.example.kuyou.object;

/*
* 用于保存热门活动，用于接口11
* */
public class HotActivity {
    private  long a_id;
    private long look_num;
    private long l_id;
    private String l_content;
    private long u_id;

    public long getA_id() {
        return a_id;
    }

    public void setA_id(long a_id) {
        this.a_id = a_id;
    }

    public long getLook_num() {
        return look_num;
    }

    public void setLook_num(long look_num) {
        this.look_num = look_num;
    }

    public long getL_id() {
        return l_id;
    }

    public void setL_id(long l_id) {
        this.l_id = l_id;
    }

    public String getL_content() {
        return l_content;
    }

    public void setL_content(String l_content) {
        this.l_content = l_content;
    }

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }
}
