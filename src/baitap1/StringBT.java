package baitap1;
import java.util.Arrays;
import java.util.Scanner;

public class StringBT {
    public static void main(String[] args) {

        String testString = "   Hello World ";
        System.out.println(testString);
        System.out.println(testString.isEmpty());
        System.out.println(testString.trim());

        String testString2 = "hello world";
        System.out.println(testString.trim().equals(testString2));
        System.out.println(testString.trim().equalsIgnoreCase(testString2));

//        String[] str3 = testString2.split(" ");
//        // [10, 2, 3, 4]
//        for(String element: str3){
//            System.out.println(element);
//        }

        System.out.println(Arrays.toString(testString2.split(" ")));
        String testString3 = " nice";
        System.out.println(testString2.concat(testString3));

        String testString4 = "llo";
        System.out.println(testString.contains(testString4));

        System.out.println(testString.toUpperCase());
        System.out.println(testString.toLowerCase());
        System.out.println(testString2.replace('l','e'));
        System.out.println(testString2.length());
    }

}
