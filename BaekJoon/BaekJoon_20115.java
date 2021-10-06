import java.util.*;

public class BaekJoon_20115 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] drink=new int[n];
		
		for(int i=0;i<n;i++)
			drink[i]=sc.nextInt();
		
		Arrays.sort(drink);
		
		/*
		 * 음료는 제일 양이 많은 음료를 제외하고
		 * 모두 반만 더해지기 때문에 모든 음료의 양 절반의 누적합을 구한다. 
		 */
		double sum=0;
		for(int i=0;i<n-1;i++) {
			sum+=(double)drink[i]/2;
		}
		
		// 제일 양이 많은 음료를 더해준 값을 출력한다.
		System.out.println(sum+drink[n-1]);
	}

}
