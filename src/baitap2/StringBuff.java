package baitap2;

public class StringBuff {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.append("Hello World"));

        System.out.println(sb.insert(1,"abc"));
        System.out.println(sb.replace(0,1,"2"));
        System.out.println(sb.delete(0,5));
        System.out.println(sb.length());
        System.out.println(sb.reverse());
    }
}
