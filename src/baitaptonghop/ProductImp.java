package baitaptonghop;

import java.util.Scanner;

public class ProductImp {
    public static Product[] arrProducts = new Product[100];
public static int indexProduct = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("=======menu========");
            System.out.println("1. nhập số lượng sản phẩm cần thêm");
            System.out.println("2.hiển thị thông tin sản phẩm");
            System.out.println("3.tính lợi nhuận");
            System.out.println("4. sắp xếp lợi nhậm theo giảm dần");
            System.out.println("5.thống kê sản phẩm theo giá");
            System.out.println("6.tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("7.nhập sản phẩm");
            System.out.println("8.bán sản phẩm");
            System.out.println("9.nhập trạng thái saản phẩm");
            System.out.println("10.thoát");
            System.out.println("lưa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch(choice) {
                case 1:
                    inputAddProduct(sc);
                    break;
                case 2:
                    listProduct(sc);
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;

            }
        }while (true);
    }
    public static void inputAddProduct(Scanner sc) {
        System.out.println("nhập số lượng cần thêm");
        int qtyProduct = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < qtyProduct;i++){
            Product product =  new Product();
            product.inputData(sc);
            arrProducts[indexProduct] = product;
            indexProduct++;
        }
        System.out.println("thêm" +qtyProduct +"thành công");
    }
    public static void listProduct(Scanner sc) {
        for(int i = 0; i < indexProduct; i++){
            if(indexProduct == 0){
                System.out.println("chưa có sản phẩm");
            }else {

            }
        }
    }
}
