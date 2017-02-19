package com.company.domain;

import com.company.generation.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mrs Hoang on 17/02/2017.
 */
public class Video extends Goods{

    private final int duration;

    private final String director;

    private final List<String> actors = new ArrayList<>();

    protected Video(Builder builder){
        super(builder);
        this.duration = builder.duration;
        this.director = builder.direction;
        this.actors.addAll(builder.actors);
    }

    public static class Builder extends Goods.Builder<Builder>{

        private int duration;

        private String direction;

        private List<String> actors = new ArrayList<>();

        public Builder(){}

        public Builder duration(int duration){
            this.duration = duration;
            return this;
        }

        public Builder direction(String direction){
            this.direction = direction;
            return this;
        }

        public Builder actors(String actor){
            this.actors.add(actor);
            return this;
        }

        public Video build() {
            return new Video(this);
        }
    }

    @Override
    public String toString() {
        return "Video{"
                + "id='" + super.getId() + '\''
                + "name='" + super.getName() + '\''
                + "description='" + super.getDescription() + '\''
                + "duration=" + duration
                + ", director='" + director + '\''
                + ", actors=" + actors
                + '}';
    }
}
