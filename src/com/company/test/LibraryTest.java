package com.company.test;

import com.company.domain.*;
import com.company.domain.Rule;
import org.junit.*;
import org.junit.rules.TestName;

/**
 * Created by Mrs Hoang on 19/02/2017.
 */
public class LibraryTest {

    private Library library;

    @org.junit.Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() throws Exception {
        library = new Library(3);
        addBook();
        addVideo();
        addCds();
        addRule();

        Assert.assertNotNull(library);
    }

    @Test
    public void addUser() throws Exception {

        User user = new User();
        user.setName(testName.getMethodName());
        user.setAge(18);
        user.setId(library.getNexIdUser());

        Lend lend = new Lend(library.getPeriod());

        Book book1 = library.getBook(1);
        Book book2 = library.getBook(2);
        Book book3 = library.getBook(3);

        lend.addGoods(book1);
        lend.addGoods(book2);
        lend.addGoods(book3);

        user.setLend(lend);
        library.addLend(user);
        System.out.println(user);
        Assert.assertEquals(1, library.getUsers().size());

    }

    @Test
    public void getGoods() throws Exception{

        Book book = library.getBook(1);
        System.out.println(book);

    }

    public void addBook() throws Exception {

        Book book1 = new Book.Builder().id(library.getNextIdBooks()).name("ABC").build();
        Book book2 = new Book.Builder().id(library.getNextIdBooks()+1).name("ABC").build();
        Book book3 = new Book.Builder().id(library.getNextIdBooks()+2).name("ABC").build();
        Book book4 = new Book.Builder().id(library.getNextIdBooks()+3).name("ABC").build();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
    }


    public void addVideo() throws Exception {
        int id = library.getNextIdVideos();
        Video video1= new Video.Builder().id(id).name("ABC").direction("ABC").actors("ABC").duration(90).build();
        Video video2= new Video.Builder().id(++id).name("ABC").direction("ABC").actors("ABC").duration(90).build();
        Video video3= new Video.Builder().id(++id).name("ABC").direction("ABC").actors("ABC").duration(90).build();
        Video video4= new Video.Builder().id(++id).name("ABC").direction("ABC").actors("ABC").duration(90).build();
        library.addVideo(video1);
        library.addVideo(video2);
        library.addVideo(video3);
        library.addVideo(video4);
    }


    public void addCds() throws Exception{
        int id = library.getNextIdVideos();
        CD cd1 = new CD.Builder().id(id).name("ABC").production("ABC").bulid();
        CD cd2 = new CD.Builder().id(++id).name("ABC").production("ABC").bulid();
        CD cd3 = new CD.Builder().id(++id).name("ABC").production("ABC").bulid();
        CD cd4 = new CD.Builder().id(++id).name("ABC").production("ABC").bulid();
        library.addCD(cd1);
        library.addCD(cd2);
        library.addCD(cd3);
        library.addCD(cd4);
    }

    public void addRule() throws Exception{
        Rule ruleAdult = new Rule.Builder().id(1).name("Adult").minAge(18).maxAge(100).maxGoods(7).maxBook(5).maxVideo(3).maxCd(3).build();
        Rule ruleChild = new Rule.Builder().id(2).name("Adult").minAge(5).maxAge(17).maxGoods(5).maxBook(3).maxVideo(2).build();

        library.addRule(ruleAdult);
        library.addRule(ruleChild);
    }

}