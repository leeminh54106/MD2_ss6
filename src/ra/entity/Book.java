package ra.entity;

import ra.run.BookImp;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    //constructor
    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    //get/set
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void inputBook(Scanner scanner) {
        //mã sách,ko trùng lặp
        this.bookId = inputBookId(scanner);
        //tên sách, ko trùng lặp,4 kí tự, bắt đầu = B
        this.bookName = inputBookName(scanner);
        //giá nhập >0
        this.importPrice = inputImportPrice(scanner);
        //giá bán >30% giá mua
        this.exportPrice = inputExportPrice(scanner);
        //tên tác giả 6 > 50 kí tự
        this.author = inputAuthor(scanner);
        //năm xuất bản > 2000
        this.year = inputYear(scanner);
        // lợi nhuận
        this.interest = inputInterest();
    }

    public String inputBookId(Scanner scanner) {
        System.out.println("nhập mã");
        do {
            String bookId = scanner.nextLine();
            boolean isExit = false;
            for (int i = 0; i < BookImp.bookIndex; i++) {
                if (BookImp.arrBook[i].getBookId().equals(bookId)) {
                    isExit = true;
                    break;
                }
            }
            if(isExit){
                System.err.println("sách đã tồn tại");
            }else {
                return bookId;
            }
        } while (true);
    }

    public String inputBookName(Scanner scanner) {
        System.out.println("nhập tên sách");
        do {
            String bookName = scanner.nextLine();
            boolean isExit = false;
            if (bookName.startsWith("B")) {
                if (bookName.length() == 4) {
                    for (int i = 0; i < BookImp.bookIndex; i++) {
                        if (BookImp.arrBook[i].getBookName().equals(bookName)) {
                            isExit = true;
                        }
                    }
                    if(isExit){
                        System.err.println("sách đã tồn tại");
                    }else {
                        return bookName;
                    }
                } else {
                    System.err.println("phải có 4 kí tự");
                }
            } else {
                System.err.println("bắt đầu = B");
            }
        } while (true);
    }

    public float inputImportPrice(Scanner scanner) {
        System.out.println("giá nhập vào");

        do {
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice == 0) {
                System.err.println("giá phải >0");
            } else {
                return importPrice;
            }
        } while (true);
    }

    public float inputExportPrice(Scanner scanner) {
        System.out.println("giá bán");

        do {
            float exportPrice = Float.parseFloat(scanner.nextLine());
            if (exportPrice < this.importPrice * 1.3) {
                System.err.println("giá bán phải > giá nhập 30%");
            } else {
                return exportPrice;
            }
        } while (true);
    }
    public String inputAuthor(Scanner scanner) {
        System.out.println("nhập tên tác giả");
        do {
            String author = scanner.nextLine();
            if(author.length()>6 && author.length()<50){
                return author;
            }else {
                System.err.println("tên tác giả 6 > 50 kí tự");
            }
        }while (true);
    }
    public int inputYear(Scanner scanner) {
        System.out.println("nhập năm xuất bản");

        do {
            int year = Integer.parseInt(scanner.nextLine());
            if(year < 2000){
                System.err.println("năm xuất bản phải > 2000");
            }else {
                return year;
            }
        }while (true);
    }

    public float inputInterest(){
        return this.exportPrice - this.importPrice;
    }
    public void displayBook(){
        System.out.printf("|ID %s |Name %s |Giá nhập %.0f |Giá bán %.0f |\n", this.bookId, this.bookName, this.importPrice, this.exportPrice);
        System.out.printf("|Tác giả %s |NXB %d |Lợi nhuận %.0f\n",this.author,this.year,this.interest);
    }
}
