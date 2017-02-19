package com.company.domain;

import com.company.generation.Goods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mrs Hoang on 17/02/2017.
 */
public class Library {

    List<User> users;

    List<Book> books;

    List<Video> videos;

    List<CD> cds;

    List<Rule> rules;

    private int period = 3;

    public Library(int period) {
        this.period = period;
        users = new ArrayList<>();
        books = new ArrayList<>();
        videos = new ArrayList<>();
        cds = new ArrayList<>();
        rules = new ArrayList<>();
    }

    public void addLend(User user) {

        this.users.add(user);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Book getBook(int id) {
        Iterator<Book> itBook = books.iterator();
        while (itBook.hasNext()){
            Book book = itBook.next();
            if(id == book.getId())
                return book;
        }
        return null;
    }

    public Video getVideo(int id) {
        Iterator<Video> itVideo = videos.iterator();
        while (itVideo.hasNext()){
            Video video = itVideo.next();
            if(id == video.getId())
                return video;
        }
        return null;
    }

    public CD getCD(int id) {
        Iterator<CD> itCD = cds.iterator();
        while (itCD.hasNext()){
            CD cd = itCD.next();
            if(id == cd.getId())
                return cd;
        }
        return null;
    }

    public void addVideo(Video video) {
        videos.add(video);
    }


    public void addCD(CD cd) {
        cds.add(cd);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<CD> getCds() {
        return cds;
    }

    public void setCds(List<CD> cds) {
        this.cds = cds;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void addRule(Rule rule){
        rules.add(rule);
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public int getNextId(List<? extends Goods> list){
        int size = list.size();
        if(size == 0)
            return 1;
        return list.get(size-1).getId() + 1 ;
    }

    public int getNextIdBooks(){
        return getNextId(getBooks());
    }

    public int getNextIdVideos(){
        return getNextId(getVideos());
    }

    public int getNextIdCds(){
        return getNextId(getCds());
    }

    public int getNexIdUser(){
        int size = users.size();
        if(size == 0)
            return 1;
        return users.get(size-1).getId() + 1 ;
    }

    public Rule getRule(int age){
        Iterator<Rule> itRule = rules.iterator();
        while (itRule.hasNext()){
            Rule rule = itRule.next();
            if(age >= rule.getMinAge() && age <= rule.getMaxAge())
                return rule;
        }
        return null;
    }

    public User getUserByName(String name){
        Iterator<User> itUser = users.iterator();
        while (itUser.hasNext()){
            User user = itUser.next();
            if(name.equals(user.getName()))
                return user;
        }
        return null;
    }

    public void removeUser(int id){
        Iterator<User> itUser = users.iterator();
        while (itUser.hasNext()){
            User user = itUser.next();
            if(id == user.getId())
                itUser.remove();
        }
    }


}
