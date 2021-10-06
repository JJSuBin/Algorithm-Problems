import java.util.*;

/*
 * 이항 계수를 구하는 공식은 nCm = n! / (n-m)! * m! 이다.
 * 0은 2와 5의 곱으로 만들어지기 때문에 n!에서의 2와 5의 개수에서
 * (n-m)! * m!에서 만들어지는 2와 5의 개수를 빼주면 된다. 
 * 지수는 나눗셈인 경우 뺄셈으로 계산하기 때문이다.
 * 이렇게 구해진 5와 2의 개수 중 작은 숫자가 문제의 해답이 된다.
 */
public class BaekJoon_2004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long N=sc.nextLong();
		long M=sc.nextLong();
		
		 //n!에서의 2와 5의 개수에서 (n-m)! * m!에서 만들어지는 2와 5의 개수를 빼준다.
		long count5=five_power_n(N)-five_power_n(N-M)-five_power_n(M);
		long count2=two_power_n(N)-two_power_n(N-M)-two_power_n(M);
        
		// 5와 2의 개수 중 더 작은 값을 출력해야 그 만큼 0이 만들어진다.
		System.out.println(Math.min(count5,count2));
	}
	
	// 5의 승수를 구하는 함수 
	static long five_power_n(long num) {
		int count = 0;
		// 숫자를 5로 나눠 5의 개수를 구해준다.
		while(num>= 5) {
			count+=(num/5);
			num/=5;
		}
		return count;
	}
		
	// 2의 승수를 구하는 함수
	static long two_power_n(long num) {
		int count = 0;
		// 숫자를 2로 나눠 2의 개수를 구해준다
		while(num >= 2) {
			count+=(num/2);
			num/=2;
		}
		return count;
	}
}
