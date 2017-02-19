package com.company.domain;

import com.company.generation.Goods;

/**
 * Created by Mrs Hoang on 17/02/2017.
 */
public class CD extends Goods {


    protected CD(Builder builder){
        super(builder);
    }

    public static class Builder extends Goods.Builder<Builder>{

        private String production;

        public Builder(){}

        public CD bulid() {
            return new CD(this);
        }
    }

    @Override
    public String toString() {
        return "CD{"
                + "id='" + super.getId() + '\''
                + "name='" + super.getName() + '\''
                + "description='" + super.getDescription() + '\''
                + "production='" + super.getProduction() + '\''
                + '}';
    }
}
