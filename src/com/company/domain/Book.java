package com.company.domain;


import com.company.generation.Goods;

/**
 * Created by Mrs Hoang on 17/02/2017.
 */
public class Book extends Goods {

    private final String author;

    protected Book(Builder builder) {
        super(builder);
        author = builder.author;
    }

    public static class Builder extends Goods.Builder<Builder>{

        private String author;

        public Builder(){}

        public Builder author(String author){
            this.author = author;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    @Override
    public String toString() {
        return "Book{"
                + "id='" + super.getId() + '\''
                + "name='" + super.getName() + '\''
                + "description='" + super.getDescription() + '\''
                + "author='" + author + '\''
                + '}';
    }
}
