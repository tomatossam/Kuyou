package com.example.kuyou.object;

/*
 * 用于video/information接口的实体类：短视频信息类
 * */

public class Video {
    private long v_id;
    private String v_cover;
    private String v_content;
    private long v_creator;
    private String v_date;
    private long m_id;
    private String v_description;
    private long v_thumb_num;
    private long share_num;
    private long common_num;

    private long view_id;
    private String country;
    private String province;
    private String city;
    private String place;
    private String position;

    private String m_title;

    // 保存国家
    Object[] countries;

    public long getV_id() {
        return v_id;
    }

    public void setV_id(long v_id) {
        this.v_id = v_id;
    }

    public String getV_cover() {
        return v_cover;
    }

    public void setV_cover(String v_cover) {
        this.v_cover = v_cover;
    }

    public String getV_content() {
        return v_content;
    }

    public void setV_content(String v_content) {
        this.v_content = v_content;
    }

    public long getV_creator() {
        return v_creator;
    }

    public void setV_creator(long v_creator) {
        this.v_creator = v_creator;
    }

    public String getV_date() {
        return v_date;
    }

    public void setV_date(String v_date) {
        this.v_date = v_date;
    }

    public long getM_id() {
        return m_id;
    }

    public void setM_id(long m_id) {
        this.m_id = m_id;
    }

    public String getV_description() {
        return v_description;
    }

    public void setV_description(String v_description) {
        this.v_description = v_description;
    }

    public long getV_thumb_num() {
        return v_thumb_num;
    }

    public void setV_thumb_num(long v_thumb_num) {
        this.v_thumb_num = v_thumb_num;
    }

    public long getShare_num() {
        return share_num;
    }

    public void setShare_num(long share_num) {
        this.share_num = share_num;
    }

    public long getCommon_num() {
        return common_num;
    }

    public void setCommon_num(long common_num) {
        this.common_num = common_num;
    }

    public String getM_title() {
        return m_title;
    }

    public void setM_title(String m_title) {
        this.m_title = m_title;
    }

    public long getView_id() {
        return view_id;
    }

    public void setView_id(long view_id) {
        this.view_id = view_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Object[] getCountries() {
        return countries;
    }

    public void setCountries(Object[] countries) {
        this.countries = countries;
    }
}
