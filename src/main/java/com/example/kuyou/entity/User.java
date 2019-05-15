package com.example.kuyou.entity;

public class User {

        private String nick;
        private String head;
        private String signature;
        private String isfollowed;

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
