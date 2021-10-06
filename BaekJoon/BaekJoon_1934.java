import java.util.*;

public class BaekJoon_1934 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			int d=gcd(b,a); // 최대공약수 
			
			System.out.println(a*b/d); // 최소공배수 = 두 수의 곱 / 최대공약수
		}
	}
	
	// 최대공약수 구하는 함수
	public static int gcd(int a, int b) {
		while(b!=0) {
			int r=a%b;
			
			a=b;
			b=r;
		}
		return a;
	}
}
