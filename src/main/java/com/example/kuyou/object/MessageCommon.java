package com.example.kuyou.object;

public class MessageCommon {
    private long vc_id;
    private String vc_content;
    private long v_id;
    private long u_id;
    private String vc_time;
    private String vc_date;
    private long parent_id;

    public long getVc_id() {
        return vc_id;
    }

    public void setVc_id(long vc_id) {
        this.vc_id = vc_id;
    }

    public String getVc_content() {
        return vc_content;
    }

    public void setVc_content(String vc_content) {
        this.vc_content = vc_content;
    }

    public long getV_id() {
        return v_id;
    }

    public void setV_id(long v_id) {
        this.v_id = v_id;
    }

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public String getVc_time() {
        return vc_time;
    }

    public void setVc_time(String vc_time) {
        this.vc_time = vc_time;
    }

    public String getVc_date() {
        return vc_date;
    }

    public void setVc_date(String vc_date) {
        this.vc_date = vc_date;
    }

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }
}
