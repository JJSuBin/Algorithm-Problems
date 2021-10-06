import java.util.*;

/*
 * 이항 계수 공식
 * nCr = n! / r!(n-r)! 
 */
public class BeakJoon_11050 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		System.out.println(factorial(n)/(factorial(k)*factorial(n-k)));
	}
	// 팩토리얼 계산 함수
	public static int factorial(int n) {
		if(n==0)
			return 1;
		return n*factorial(n-1);
	}
}
