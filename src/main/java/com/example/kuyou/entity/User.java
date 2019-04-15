package com.example.kuyou.entity;

public class User {

    private long u_id;
    private String bg_img;
    private enum travel_stat{Y,N};
    private String head;
    private String nick;
    private String signature;
    private int age;
    private enum sex{男,女};
    private String city;
    private String school;
    private long thumb_num;
    private long following_num;
    private long fans_num;
    private long works_num;
    private long like_num;
    private int country_num;
    private int city_num;
    private int place_num;
    private long activity_num;
    private String phone;
    private String password;

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public String getBg_img() {
        return bg_img;
    }

    public void setBg_img(String bg_img) {
        this.bg_img = bg_img;
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public long getThumb_num() {
        return thumb_num;
    }

    public void setThumb_num(long thumb_num) {
        this.thumb_num = thumb_num;
    }

    public long getFollowing_num() {
        return following_num;
    }

    public void setFollowing_num(long following_num) {
        this.following_num = following_num;
    }

    public long getFans_num() {
        return fans_num;
    }

    public void setFans_num(long fans_num) {
        this.fans_num = fans_num;
    }

    public long getWorks_num() {
        return works_num;
    }

    public void setWorks_num(long works_num) {
        this.works_num = works_num;
    }

    public long getLike_num() {
        return like_num;
    }

    public void setLike_num(long like_num) {
        this.like_num = like_num;
    }

    public int getCountry_num() {
        return country_num;
    }

    public void setCountry_num(int country_num) {
        this.country_num = country_num;
    }

    public int getCity_num() {
        return city_num;
    }

    public void setCity_num(int city_num) {
        this.city_num = city_num;
    }

    public int getPlace_num() {
        return place_num;
    }

    public void setPlace_num(int place_num) {
        this.place_num = place_num;
    }

    public long getActivity_num() {
        return activity_num;
    }

    public void setActivity_num(long activity_num) {
        this.activity_num = activity_num;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
