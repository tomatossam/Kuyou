package com.example.kuyou.entity;

public class Musicinfo {

    private long m_creator;
    private long user_num;
    private String m_cover;
    private String m_content;
    private long isCollected;

    public long getM_creator() {
        return m_creator;
    }

    public void setM_creator(long m_creator) {
        this.m_creator = m_creator;
    }

    public long getUser_num() {
        return user_num;
    }

    public void setUser_num(long user_num) {
        this.user_num = user_num;
    }

    public String getM_cover() {
        return m_cover;
    }

    public void setM_cover(String m_cover) {
        this.m_cover = m_cover;
    }

    public String getM_content() {
        return m_content;
    }

    public void setM_content(String m_content) {
        this.m_content = m_content;
    }

    public long getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(int isCollected) {
        this.isCollected = isCollected;
    }
}
