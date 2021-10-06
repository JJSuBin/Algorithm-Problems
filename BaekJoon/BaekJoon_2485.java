import java.util.*;

public class BaekJoon_2485 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] position=new int[n];
		
		for(int i=0;i<n;i++)
			position[i]=sc.nextInt();
		
		// 각 가로수들의 간격을 구한다.
		int[] diff=new int[n-1];
		for(int i=0;i<n-1;i++)
			diff[i]=position[i+1]-position[i];
		
		// 간격들간의 최대 공약수를 찾는다.
		int gcd=gcd(diff[0],diff[1]);
		for(int i=2;i<n-2;i++) {
			gcd=gcd(gcd,diff[i]);
			
			if(gcd==1)
				break;
		}
		
		/*
		 * 예를 들어 가로수가 (1,3,7,13)에 심어져있다면 각 가로수간의 간격은
		 * (2,4,6)이 되고, 간격들의 최대 공약수는 2가 된다. 
		 * 그리고 (각 거리의 차를 최대 공약수로 나눈 몫) -1의 누적 합이 
		 * 설치해야하는 가로수의 개수가 된다.
		 */
		int count=0;
		for(int i=0;i<n-1;i++)
			count+=((diff[i]/gcd)-1);
		
		System.out.println(count);
	}
	
	// 유클리도 호제법으로 최대공약수를 구하는 함수
	public static int gcd(int a, int b) {
		while(b>0) {
			int temp=b;
			b=a%b;
			a=temp;
		}
		return a;
	}
}
