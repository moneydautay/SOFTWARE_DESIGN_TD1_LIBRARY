package com.company.domain;

/**
 * Created by Mrs Hoang on 17/02/2017.
 */
public class Rule {

    private final int id;

    private final String name;

    private int minAge = 0;

    private int maxAge = 0;

    private int maxGoods = 0;

    private int maxBook = 0;

    private int maxVideo = 0;

    private int maxCd = 0;

    protected Rule(Builder builder) {

        this.id = builder.id;
        this.name = builder.name;
        this.minAge = builder.minAge;
        this.maxAge = builder.maxAge;
        this.maxGoods = builder.maxGoods;
        this.maxBook = builder.maxBook;
        this.maxVideo = builder.maxVideo;
        this.maxCd = builder.maxCd;

    }

    public static class Builder{

        private int id;

        private String name;

        private int minAge = 0;

        private int maxAge = 0;

        private int maxGoods = 0;

        private int maxBook = 0;

        private int maxVideo = 0;

        private int maxCd = 0;

        public Builder(){}

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder minAge(int age){
            this.minAge = age;
            return this;
        }

        public Builder maxAge(int age){
            this.maxAge = age;
            return this;
        }

        public Builder maxGoods(int maxGoods){
            this.maxGoods = maxGoods;
            return this;
        }

        public Builder maxBook(int maxBook){
            this.maxBook = maxBook;
            return this;
        }

        public Builder maxVideo(int maxVideo){
            this.maxVideo = maxVideo;
            return this;
        }

        public Builder maxCd(int maxCd){
            this.maxCd = maxCd;
            return this;
        }

        public Rule build(){
            return new Rule(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMaxGoods() {
        return maxGoods;
    }

    public void setMaxGoods(int maxGoods) {
        this.maxGoods = maxGoods;
    }

    public int getMaxBook() {
        return maxBook;
    }

    public void setMaxBook(int maxBook) {
        this.maxBook = maxBook;
    }

    public int getMaxVideo() {
        return maxVideo;
    }

    public void setMaxVideo(int maxVideo) {
        this.maxVideo = maxVideo;
    }

    public int getMaxCd() {
        return maxCd;
    }

    public void setMaxCd(int maxCd) {
        this.maxCd = maxCd;
    }

    @Override
    public String toString() {
        return "Rule{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", minAge=" + minAge
                + ", maxAge=" + maxAge
                + ", maxGoods=" + maxGoods
                + ", maxBook=" + maxBook
                + ", maxVideo=" + maxVideo
                + ", maxCd=" + maxCd
                + '}';
    }
}
