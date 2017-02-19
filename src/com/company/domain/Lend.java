package com.company.domain;

import com.company.generation.Goods;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mrs Hoang on 17/02/2017.
 */
public class Lend {

    private LocalDateTime beginDate;

    private LocalDateTime endDate;

    private List<Goods> goods;

    public Lend(int period) {
        goods = new ArrayList<>();
        this.beginDate = LocalDateTime.now(Clock.systemDefaultZone());
        this.endDate = beginDate.plusDays(period);
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public void addGoods(Goods goods){
        this.goods.add(goods);
    }

    @Override
    public String toString() {
        return "Lend{"
                + ", beginDate=" + beginDate
                + ", endDate=" + endDate
                + ", goods=" + goods
                + '}';
    }
}
