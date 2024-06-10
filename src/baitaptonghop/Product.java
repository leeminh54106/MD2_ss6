package baitaptonghop;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Product(String productId, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;

    }

    public void inputData(Scanner sc){
    this.productId = inputProductId(sc);
    this.productName = inputProductName(sc);
    this.importPrice = inputImportPrice(sc);
    this.exportPrice = inputexPortPrice(sc);
    this.profit = calProfit();
    this.quantity = inputQuantity(sc);
    this.descriptions = inputDescriptions(sc);
    this.status = inputStatus(sc);
    }

    public void displayData(){
        System.out.println("=======thông tin sản  phẩm===========");
        System.out.println("mã: " + this.productId);
        System.out.println("tên: " + this.productName);
        System.out.println("giá nhập: " + this.importPrice);
        System.out.println("giá bán: " + this.exportPrice);
        System.out.println("lợi nhuận: " + this.profit);
        System.out.println("số lượng: " + this.quantity);
        System.out.println("mô tản: " + this.descriptions);
        System.out.println("trạng thái: " + (this.status? "đang bán":"không bán"));
        System.out.println("=====================================");
    }

    public String inputProductId(Scanner sc){
        do{
            System.out.println("nhập mã sản phẩm");
            String productId = sc.nextLine();
            boolean isExist = false;
            if(productId.length() == 4){
                for( int i = 0; i < ProductImp.indexProduct;i++){
                    if(ProductImp.arrProducts[i].getProductId().equals(productId)){
                        isExist = true;
                        break;
                    }
                }
                if(isExist){
                    System.out.println("đã tồn tại");
                }else {
                    return productId;
                }
            }else {
                System.out.println("mã sản phẩm phải gồm 4 ký tự");
            }
        }while (true);
    }
    public String inputProductName(Scanner sc){
        do{
            System.out.println("nhập tên sản phẩm");
            String productName = sc.nextLine();
            boolean isExist = false;
            if(productName.length() >=6 && productName.length() <= 50){
                for( int i = 0; i < ProductImp.indexProduct;i++){
                    if(ProductImp.arrProducts[i].getProductName().equals(productName)){
                        isExist = true;
                        break;
                    }
                }
                if(isExist){
                    System.out.println("đã tồn tại");
                }else {
                    return productName;
                }
            }else {
                System.out.println("tên sản phẩm phải 6 ->50");
            }
        }while (true);
    }
    public  float inputImportPrice(Scanner sc){
        do{
            System.out.println("nhập giá mua vào");
            float importPrice = Float.parseFloat(sc.nextLine());
            if(importPrice > 0){
                return importPrice;
            }else {
                System.out.println(">0");
            }
        }while (true);
    }
    public  float inputexPortPrice(Scanner sc){
        do{
            System.out.println("Nhập giá bán");
            float exportPrice = Float.parseFloat(sc.nextLine());
            if(exportPrice > this.importPrice*1.2){
                return exportPrice;
            }else {
                System.out.println("lớn hơn giá nhập 20%");
            }
        }while (true);
    }
    public float calProfit(){
        return this.exportPrice - this.importPrice;
    }
    public int inputQuantity(Scanner sc){
        do{
            System.out.println("nhập số lươngk");
            int qty = Integer.parseInt(sc.nextLine());
            if(qty >0){
                return qty;
            }else {
                System.out.println("số lượng >0");
            }
        }while (true);
    }
    public String inputDescriptions(Scanner sc){
        System.out.println("viết  mô tả");
        return sc.nextLine();
    }
    public boolean inputStatus(Scanner sc){
        do{
            System.out.println("nhập vào true/false");
            String status = sc.nextLine();
            if(status.equals("true")||status.equals("false")){
                return Boolean.parseBoolean(status);
            }else {
                System.out.println("nhập true/false");
            }
        }while (true);
    }
}
