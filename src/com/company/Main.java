package com.company;

import com.company.domain.*;
import com.company.generation.Goods;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static Library library;

    private static int numBook = 0;
    private static int numVideo = 0;
    private static int numCd = 0;

    public static void main(String[] args) {
        library = new Library(3);
        addBook();
        addVideo();
        addCds();
        addRule();

        //print command
        printCommand();

        Scanner sc = new Scanner(System.in);
        System.out.print("Input key command: ");
        while(sc.hasNextLine()){
            String rdLine = sc.next();
            if(rdLine.equals("exit")) {
                System.out.println("System suspend...");
                break;
            }

            if(rdLine.equals("1")){
                listBook();
            }

            if (rdLine.equals("2")){
                listVideo();
            }

            if (rdLine.equals("3")){
                listCD();
            }

            if (rdLine.equals("4")){
                lendGoods();
            }

            if (rdLine.equals("5")){
                returnGoods();
            }

            if (rdLine.equals("6")) {
                listLend();
            }

            System.out.print("Input key command: ");
            
        }
	// write your code here
    }

    public static void  printCommand(){
        System.out.println();
        System.out.println("*======================== LIBRARY =========================*");
        System.out.println("* 1: Listing Book  || 2: Listing Video || 3: Listing CD    *");
        System.out.println("*----------------------------------------------------------*");
        System.out.println("* 4: Lend          || 5: Return        || 6: Listing lend  *");
        System.out.println("************************************************************");
        System.out.println("*====================== LIBRARY ===========================*");
        System.out.println();
    }

    public static void returnGoods(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        while (sc.hasNext()){
            String rdLine = sc.next();
            User user = library.getUserByName(rdLine);
            if(user == null)
                System.out.println("Name has been not found..");
            else
                System.out.println(user);
            System.out.println("1: Find user || 2: return || 3: cancel");
            rdLine = sc.next();
            if(rdLine.equals("2")){
                library.removeUser(user.getId());
                System.out.println("User returned successfully");
                break;
            }
            if(rdLine.equals("3"))
                break;
            System.out.print("Name: ");
        }
    }

    public static void lendGoods(){
        User user = new User();
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        user.setName(sc.next());

        System.out.print("Age: ");
        Integer age = Integer.valueOf(sc.next());
        user.setAge(age);

        Rule rule = library.getRule(age);

        System.out.println("Your can borrow: ");
        System.out.println("- " + rule.getMaxGoods() + "things:");
        System.out.println("+ " + rule.getMaxBook() + " books");
        System.out.println("+ " + rule.getMaxVideo() + " videos");
        System.out.println("+ " + rule.getMaxCd() + " cds");

        Lend lend = new Lend(library.getPeriod());

        System.out.println("1: add book || 2: add video || 3: CD");

        numBook = 0;
        numVideo = 0;
        numCd = 0;

        while (sc.hasNext()){

            String rdLine = sc.next();
            Goods goods = null;

            if( (numBook + numVideo + numCd) >= rule.getMaxGoods()){
                System.out.println("You reached limited things can borrow...");
                System.out.println("Press s to save and c to cancel");

                while (sc.hasNext()){
                    rdLine = sc.next();
                    if(rdLine.equals("s")) {
                        library.addLend(user);
                        return;
                    }
                    else if(rdLine.equals("c"))
                        return;
                    else
                        System.out.println("Key is invalid");
                }
            }

            if(rdLine.equals("4")){
                user.setLend(lend);
                user.setId(library.getNexIdUser());
                library.addLend(user);
                System.out.println("Saved..Bye");
                break;

            }

            if(rdLine.equals("5")){
                System.out.println("Canceled..Bye");
                break;

            }
            if(rdLine.equals("1")){
                if(numBook >= rule.getMaxBook()) {
                    System.out.println("Sorry! You reached limited book can borrow..");
                    System.out.println();
                }else {
                    System.out.print("ID book: ");
                    rdLine = sc.next();
                    goods = library.getBook(Integer.parseInt(rdLine));
                }
            }

            if(rdLine.equals("2")){
                if(numVideo >= rule.getMaxVideo()) {
                    System.out.println("Sorry! You reached limited video can borrow..");
                    System.out.println();
                }else {
                    System.out.print("ID video: ");
                    rdLine = sc.next();
                    goods = library.getVideo(Integer.parseInt(rdLine));
                }
            }

            if(rdLine.equals("3")){
                if(numCd >= rule.getMaxCd()) {
                    System.out.println("Sorry! You reached limited CD can borrow..");
                    System.out.println();
                }else {
                    System.out.print("ID cd: ");
                    rdLine = sc.next();
                    goods = library.getCD(Integer.parseInt(rdLine));
                }
            }


            if(goods != null){
                lend.addGoods(goods);
            }else {
                System.out.println("Not found..");
            }
            printLend(lend);
            System.out.println("*------------------------------------*");
            System.out.println("1: add book || 2: add video || 3: CD ");
            System.out.println("4: save     || 5: cancel ");
            System.out.println("*------------------------------------*");
        }
    }

    public static void printLend(Lend lend){
        Iterator<Goods> itGoods = lend.getGoods().iterator();

        numBook = 0;
        numVideo = 0;
        numCd = 0;
        while (itGoods.hasNext()){
            Goods goods = itGoods.next();
            if(goods instanceof Book)
                numBook ++;
            else if (goods instanceof Video)
                numVideo ++;
            else numCd ++;
            System.out.println(goods);
        }

        System.out.println("Total things: "+ lend.getGoods().size());
        System.out.println("+ Num book: " + numBook);
        System.out.println("+ Num video: " + numVideo);
        System.out.println("+ Num CD: " + numCd);
    }

    public static void listBook(){
        System.out.println();
        Iterator<Book> goods = library.getBooks().iterator();
        System.out.println("************************************************************");
        System.out.println("*                          LIST BOOKS                       *");
        System.out.println("************************************************************");
        while (goods.hasNext()){
            Book good = goods.next();
            System.out.println(good);
        }
        System.out.println("************************************************************");
    }

    public static void listVideo(){
        Iterator<Video> goods = library.getVideos().iterator();
        System.out.println();
        System.out.println("************************************************************");
        System.out.println("*                            LIST VIDEOS                   *");
        System.out.println("************************************************************");
        while (goods.hasNext()){
            Video good = goods.next();
            System.out.println(good);
        }
        System.out.println("************************************************************");
    }

    public static void listCD(){
        Iterator<CD> goods = library.getCds().iterator();
        System.out.println();
        System.out.println("************************************************************");
        System.out.println("*                            LIST CDS                      *");
        System.out.println("************************************************************");
        while (goods.hasNext()){
            CD good = goods.next();
            System.out.println(good);
        }
        System.out.println("************************************************************");
    }

    public static void listLend(){
        Iterator<User> uses = library.getUsers().iterator();
        System.out.println();
        System.out.println("************************************************************");
        System.out.println("*                            LIST LEND                      *");
        System.out.println("************************************************************");
        while (uses.hasNext()){
            User user = uses.next();
            System.out.println(user);
        }
        System.out.println("************************************************************");
    }

    public static void addBook() {

        Book book1 = new Book.Builder().id(library.getNextIdBooks()).name("ABC").build();
        Book book2 = new Book.Builder().id(library.getNextIdBooks()+1).name("ABC").build();
        Book book3 = new Book.Builder().id(library.getNextIdBooks()+2).name("ABC").build();
        Book book4 = new Book.Builder().id(library.getNextIdBooks()+3).name("ABC").build();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
    }


    public static void addVideo()  {
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


    public static void addCds() {
        int id = library.getNextIdCds();
        CD cd1 = new CD.Builder().id(id).name("ABC").production("ABC").bulid();
        CD cd2 = new CD.Builder().id(++id).name("ABC").production("ABC").bulid();
        CD cd3 = new CD.Builder().id(++id).name("ABC").production("ABC").bulid();
        CD cd4 = new CD.Builder().id(++id).name("ABC").production("ABC").bulid();
        library.addCD(cd1);
        library.addCD(cd2);
        library.addCD(cd3);
        library.addCD(cd4);
    }

    public static void addRule() {
        Rule ruleAdult = new Rule.Builder().id(1).name("Adult").minAge(18).maxAge(100).maxGoods(7).maxBook(5).maxVideo(3).maxCd(3).build();
        Rule ruleChild = new Rule.Builder().id(2).name("Adult").minAge(5).maxAge(17).maxGoods(5).maxBook(3).maxVideo(2).build();

        library.addRule(ruleAdult);
        library.addRule(ruleChild);
    }




}
