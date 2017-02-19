package com.company.generation;

/**
 * Created by Mrs Hoang on 17/02/2017.
 */
public class Goods {

    private final int id;

    private final String name;

    private final String description;

    private final String production;

    protected Goods(Builder goodsBuilder){
        this.id = goodsBuilder.id;
        this.name = goodsBuilder.name;
        this.description = goodsBuilder.description;
        this.production = goodsBuilder.production;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getProduction() {
        return production;
    }

    public static class Builder <T extends Builder>{

        private int id;
        private String name;
        private String description;
        private String production;

        public Builder() {}

        public T id(int id){
            this.id = id;
            return (T) this;
        }

        public T name(String name){
            this.name = name;
            return (T) this;
        }

        public T description(String description){
            this.description = description;
            return (T) this;
        }

        public T production(String production){
            this.production = production;
            return (T) this;
        }

        public Goods build(){
            return new Goods(this);
        }
    }
}
