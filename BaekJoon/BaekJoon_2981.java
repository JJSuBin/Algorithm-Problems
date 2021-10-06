import java.util.*;

public class BaekJoon_2981 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		Arrays.sort(arr); // 음수가 되지 않도록 정렬
		
		int gcdVal=arr[1]-arr[0]; // 양수
		
		for(int i=2;i<n;i++)
			// 직전의 최대 공약수와 다음 수(arr[i]-arr[i-1])의 최대공약수를 갱신 
			gcdVal=gcd(gcdVal,arr[i]-arr[i-1]);
		
		// 최대 공약수의 약수들 찾아 출력
		for(int i=2;i<=gcdVal;i++)
			if(gcdVal%i==0)
				System.out.print(i+" ");
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
