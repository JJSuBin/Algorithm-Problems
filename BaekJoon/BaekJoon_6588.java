import java.util.*;

public class BaekJoon_6588 {
	public static boolean[] prime=new boolean[1000001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		/*
		 * 모든 배열의 값을 true로 바꿔놓고
		 * 에라토스테네스의 채 알고리즘을 사용하여 소수가 아닌 배열의 값을
		 * false로 변경한다. 즉, 인덱스가 소수인 배열의 값을 true이다.
		 */
		for(int i=2;i<=1000000;i++)
			prime[i]=true;
		
		for(int i=2;i<=100000;i++) {
			for(int j=i*2;j<=1000000;j+=i) {
				if(!prime[j])
					continue;
				prime[j]=false;
			}
		}
		
		while(true) {
			int n=sc.nextInt();
			// 소수의 합으로 n을 나타낼 수 있는지 체크하는 변수
			boolean check=false;
			
			// 0을 입력받으면 프로그램 종료
			if(n==0)
				break;
			
			// 대칭성이라는 성질을 이용하여 n/2까지만 검사를 진행한다.
			for(int i=2;i<=n/2;i++) {
				/*
				 * 숫자 i가 소수라면 n-i도 소수일 경우 두 수의 합으로 n을 표현할 수 있다.
				 * 
				 * 예를 들어 n이 8일 경우 3이 소수이고, 8-3=5 또한 소수이기 때문에
				 * 8 = 3 + 5로 표현할 수 있다.
				 */
				if(prime[i]==true&&prime[n-i]==true) {
					System.out.println(n+" = "+i+" + "+(n-i));
					check=true;
					break;
				}
			}
			
			// 소수의 합으로 n을 나타낼 수 없는 경우
			if(!check)
				System.out.println("Goldbach's conjecture is wrong.");
		}
	}

}
