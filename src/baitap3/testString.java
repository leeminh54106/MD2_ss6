package baitap3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class testString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("nhập email của bạn: ");
        String email = sc.nextLine();

        String str = "username@OrganizationName. area symbol";
        String str1 = "rikeiacademy@rikkeisoft.com";
        String regex = "^[A-Za-z0-9]+[A-Za-z0-9]@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern.matches(regex,email);
        System.out.println(Pattern.matches(regex,email));
    }
}
