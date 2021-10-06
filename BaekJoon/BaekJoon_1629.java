import java.util.*;

public class BaekJoon_1629 {
	public static long a,b,c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		a=sc.nextLong();
		b=sc.nextLong();
		c=sc.nextLong();
		
		System.out.println(pow(a,b));
	}
	
	/*
	 * 지수를 반으로 나누는 과정을 지수가 1일 떄 까지 반복한다.
	 * 예를 들어 10^11인 경우는
	 * 10^5 * 10^5 * 10^1로 나눌 수 있고, 10^5를 또 나누면
	 * 10^2 * 10^2 * 10^1, 10^2를 또 나누면
	 * 10^1 * 10^1이 된다.
	 * 
	 * 이러한 과정에서 지수는 절반으로 나뉘기 때문에 각 단계에서 나뉜
	 * 두 지수를 모두 계산할 필요 없이 한 번만 구하면 된다.
	 */
	public static long pow(long a, long exponent) {
		// 지수가 1인 경우 a^1 이므로 a 리턴
		if(exponent==1)
			return a%c;
		
		// 지수의 절반에 해당하는 값을 구한다.
		long temp=pow(a,exponent/2);
		
		/*
		 * <모듈러 합동 공식> : (a * b) % C = ((a % C)*(b % C)) % C
		 * (temp * temp * A) % C 
		 * = ((temp * temp % C) * (A % C)) % C
		 * = (((temp * temp % C) % C) * (A % C)) % C
		 * = ((temp * temp % C) * A) % C
		 * 
		 * 이때 지수가 홀수가 될 경우는 
		 * A^(exponent / 2) * A^(exponent / 2) * A 이므로
		 * A를 한 번 더 곱해주어야 한다.
		 * 
		 * ex) A^9 = A^4 * A^4 * A
		 */
		if(exponent%2==1)
			// (temp*temp*a)%c를 변환한 식
			return (temp*temp%c)*a%c;
		
		/*
		 * 지수가 짝수인 경우에는
		 * 구했던 값을 한번 더 곱한 뒤 c 값을 나눠 반환
		 */
		return temp*temp%c;
	}
}
