import java.util.*;

public class BaekJoon_11401 {
	public static final long p=1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long n=sc.nextInt();
		long k=sc.nextInt();
		
		long number=factorial(n); // 분모
		long denom=factorial(k)*factorial(n-k)%p; // 분자 (K!*(N-K)!) mod p
		
		// N! * 분모의 역원 
		System.out.println(number*pow(denom,p-2)%p);
	}
	
	// 팩토리얼 구하는 함수
	public static long factorial(long n) {
		long result=1L;
		while(n>1) {
			result=(result*n)%p;
			n--;
		}
		return result;
	}
	
	/*
	 * 역원 구하는 함수 
	 * base : 밑, exponent : 지수
	 */
	public static long pow(long base, long exponent) {
		// 지수가 1일 경우 base^1 이므로 base%p를 리턴
		if(exponent==1)
			return base%p;
		
		// 지수의 절반에 해당하는 base^(exponent/2)를 구한다.
		long temp=pow(base,exponent/2);
		
		/*
		 * 현재 지수가 홀수 였다면
		 * base^(exponent/2) * base^(exponent/2) * base 이므로
		 * base를 한 번 더 곱해주어야 한다.
		 * 
		 * ex) A^9 = A^4 * A^4 * A
		 */
		if(exponent%2==1)
			return (temp*temp%p)*base%p;
		
		return temp*temp%p;
	}
}
