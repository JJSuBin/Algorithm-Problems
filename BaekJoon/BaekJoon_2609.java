import java.util.*;

/*
 * 최대공약수 GCD -> 유클리드 호제법
 * a와 b의 최대공약수를 (a,b)라고 할 때 (a,b)의 최대공약수는 (b,r)의 최대공약수와 같다. 여기서 r은 a를 b로 나눈 나머지를 의미한다.
 * 즉, GCD(a,b) = GCD(b,r) 
 * 예를 들어 GCD(581,322)일 때 r(나머지)=259이다. 즉, GCD(581,322)=GCD(322,259)이다.
 * 이를 반복하면 GCD(581,322) = GCD(322,259) = GCD(259 63) = GCD(63,7) = GCD(7,0) = 7 이 된다.
 */
public class BaekJoon_2609 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		int d=gcd(a,b); // 최대공약수
		
		System.out.println(d);
		System.out.println(a*b/d); // 최소공배수
	}
	
	// 최대 공약수 구하는 함수
	public static int gcd(int a, int b) {
		while(b!=0) {
			int r=a%b; // 나머지를 구해준다.
			
			// GCD(a,b) = GCD(b,r)이므로 변환
			a=b;
			b=r;
		}
		// 나머지가 0이 되면 a 자리에 있는 값이 최대 공약수
		return a;
	}
}
