package ra.run;

import ra.entity.Book;

import java.util.Scanner;

public class BookImp {
    public static Book[] arrBook = new Book[100];
    public static int bookIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("=====================MENU======================");
            System.out.println("1. Nhập thông tin n sách");
            System.out.println("2. Tính lợi nhuận các sách ");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần ");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần ");
            System.out.println("6. Tìm sách theo tên sách ");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản ");
            System.out.println("8. Thống kê số lượng sách theo tác giả ");
            System.out.println("9. Thoát ");
            System.out.println("lựa chọn của bạn");
            System.out.println("===============================================");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputAddBook(scanner);
                    break;
                case 2:
                    calculator();
                    break;
                case 3:
                    displayList();
                    break;
                case 4:
                    sortBook();
                    break;
                case 5:
                    sortInterest();
                    break;
                case 6:
                    searchBook(scanner);
                    break;
                case 7:
                    statisticalYear(scanner);
                    break;
                case 8:
                    statisticalAuthor(scanner);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.err.println("vui lòng nhâp lại");

            }
        } while (true);
    }

    public static void inputAddBook(Scanner scanner) {
        System.out.println(" số lượng sách cần nhập");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            arrBook[bookIndex] = new Book();
            arrBook[bookIndex].inputBook(scanner);
            bookIndex++;
        }
    }

    public static void calculator() {
        if (bookIndex == 0) {
            System.err.println("hiện chưa có sách");
        } else {
            for(int i = 0; i < bookIndex;i++ ){
                System.out.printf("lợi  nhuận của sách %s là %.0f\n", arrBook[i].getBookName(), arrBook[i].inputInterest());
            }

        }
    }
    public static void displayList(){
        if(bookIndex == 0){
            System.err.println("ko có sách");
        }else {
            for(int i = 0; i < bookIndex; i++){
                arrBook[i].displayBook();
            }
        }
    }
    public static void sortBook(){
        if(bookIndex == 0){
            System.err.println("chưa có sách");
        }else {
            for (int i = 0; i < bookIndex - 1; i++) {
                for (int j = i + 1; j < bookIndex; j++) {
                    if (arrBook[i].getExportPrice() > arrBook[j].getExportPrice()) {
                        Book temp = arrBook[i];
                        arrBook[i] = arrBook[j];
                        arrBook[j] = temp;
                    }
                }
            }
            System.out.println("sắp xếp thành công");
            displayList();
        }
    }
    public static void sortInterest(){
        if(bookIndex == 0){
            System.err.println("chưa có sách");
        }else {
            for (int i = 0; i < bookIndex - 1; i++) {
                for (int j = i + 1; j < bookIndex; j++) {
                    if (arrBook[i].getInterest() < arrBook[j].getInterest()) {
                        Book temp = arrBook[i];
                        arrBook[i] = arrBook[j];
                        arrBook[j] = temp;
                    }
                }
            }
            System.out.println("sắp xếp thành công");
            displayList();
        }
    }
    public static void searchBook(Scanner scanner){
        if(bookIndex == 0){
            System.err.println("ko có sách");
        }else {
            System.out.println("nhập tên sách cần tìm");
            String bookName = scanner.nextLine();
            for (int i = 0; i < bookIndex; i++) {
                if(arrBook[i].getBookName().equals(bookName)){
                    arrBook[i].displayBook();
                }
            }
        }
    }
    public static void statisticalYear(Scanner scanner){
        if(bookIndex == 0){
            System.err.println("không có sách");
        }else {
            System.out.println("nhập số năm cần thống kê");
            int year = Integer.parseInt(scanner.nextLine());
            for(int i = 0; i < bookIndex; i++){
                if(arrBook[i].getYear() == year){
                    arrBook[i].displayBook();
                }
            }
        }
    }
    public static void statisticalAuthor(Scanner scanner){
        if(bookIndex == 0){
            System.err.println("không có sách");
        }else {
            System.out.println("nhập số năm cần thống kê");
            String author = scanner.nextLine();
            for(int i = 0; i < bookIndex; i++){
                if(arrBook[i].getAuthor().equals(author)){
                    arrBook[i].displayBook();
                }
            }
        }
    }
}
