package com.example.kuyou.object;

/*
* 用于存储短视频作者的信息，用户接口3的相应参数
* */

public class Creator {
    private long u_id;
    private String head;
    private String nick;
    private String travel_stat;        // Y表示旅行中，N表示未在旅途中

    private String notice_kind;

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTravel_stat() {
        return travel_stat;
    }

    public void setTravel_stat(String travel_stat) {
        this.travel_stat = travel_stat;
    }

    public String getNotice_kind() {
        return notice_kind;
    }

    public void setNotice_kind(String notice_kind) {
        this.notice_kind = notice_kind;
    }
}
