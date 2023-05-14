import java.util.Scanner;

public class Hemming {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите 4 строчки");
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        String s3=sc.nextLine();
        String s4=sc.nextLine();
        printRes(s1,s2,s3,s4);
    }
    public static int hemmingLength (String s){
        int res=0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='1')
                res+=1;
        }
        return res;
    }
    public static String hemmingCode(String s1, String s2){
        String res="";
        for (int i=0; i<s1.length();i++){
            if (s1.charAt(i)==s2.charAt(i))
                res+="0";
            else
                res+="1";
        }
        return res;
    }
    public static void printRes(String s1, String s2, String s3, String s4){
        System.out.println("1-2 строчки");
        System.out.println("Код Хэмминга: "+ hemmingCode(s1,s2));
        System.out.println("Длина d: "+hemmingLength(hemmingCode(s1,s2)));
        System.out.println("1-3 строчки");
        System.out.println("Код Хэмминга: "+ hemmingCode(s1,s3));
        System.out.println("Длина d: "+hemmingLength(hemmingCode(s1,s3)));
        System.out.println("1-4 строчки");
        System.out.println("Код Хэмминга: "+ hemmingCode(s1,s4));
        System.out.println("Длина d: "+hemmingLength(hemmingCode(s1,s4)));
        System.out.println("2-3 строчки");
        System.out.println("Код Хэмминга: "+ hemmingCode(s2,s3));
        System.out.println("Длина d: "+hemmingLength(hemmingCode(s2,s3)));
        System.out.println("2-4 строчки");
        System.out.println("Код Хэмминга: "+ hemmingCode(s2,s4));
        System.out.println("Длина d: "+hemmingLength(hemmingCode(s2,s4)));
        System.out.println("3-4 строчки");
        System.out.println("Код Хэмминга: "+ hemmingCode(s3,s4));
        System.out.println("Длина d: "+hemmingLength(hemmingCode(s3,s4)));
    }
}
