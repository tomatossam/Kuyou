package com.example.kuyou.entity;

public class Musicinfo {

    private String nick;
    private String m_title;
    private String m_cover;
    private String m_content;
    private long isCollected;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getM_title() {
        return m_title;
    }

    public void setM_title(String m_title) {
        this.m_title = m_title;
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

    public void setIsCollected(long isCollected) {
        this.isCollected = isCollected;
    }
}
