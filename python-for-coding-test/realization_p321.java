import java.util.*;
public class realization_p321 {
public static String str;
public static int summary1=0;
public static int summary2=0;

public static void main(String[] args) {
// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
str=sc.nextLine();

// 왼쪽 부분의 자릿수 합 더하기
for(int i=0;i<str.length()/2;i++)
summary1+=str.charAt(i)-'0';

// 오른쪽 부분의 자릿수 합 더하기
for(int i=str.length()/2;i<str.length();i++)
summary2+=str.charAt(i)-'0';

// 자릿수 합에 따른 출력
if(summary1==summary2)
System.out.println("LUCKY");
else
System.out.println("READY");
}
}
