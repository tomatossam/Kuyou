package com.example.kuyou.entity;

public class User {
        private long u_id;
        private String nick;
        private String head;
        private String signature;
        private String isfollowed;

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public String getIsfollowed() {
        return isfollowed;
    }

    public void setIsfollowed(String isfollowed) {
        this.isfollowed = isfollowed;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
