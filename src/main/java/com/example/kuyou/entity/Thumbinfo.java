package com.example.kuyou.entity;

public class Thumbinfo {

    private long v_id;
    private long u_id;
    private String vt_time;
    private String vt_date;
    private String thumb_kind;

    public String getThumb_kind() {
        return thumb_kind;
    }

    public void setThumb_kind(String thumb_kind) {
        this.thumb_kind = thumb_kind;
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

    public String getVt_time() {
        return vt_time;
    }

    public void setVt_time(String vt_time) {
        this.vt_time = vt_time;
    }

    public String getVt_date() {
        return vt_date;
    }

    public void setVt_date(String vt_date) {
        this.vt_date = vt_date;
    }
}
