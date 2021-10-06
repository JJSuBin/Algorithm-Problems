import java.util.*;

public class BaekJoon_1205 {
	public static int n,score,p;
	public static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		score=sc.nextInt();
		p=sc.nextInt();
		arr=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		/*
		 * -1이 출력되는 경우는 랭킹 리스트가 다 차있는데
		 * 점수가 제일 낮은 사람보다 점수가 낮거나 같은 경우이다.
		 * 이러한 경우는 -1을 출력해주고 프로그램을 종료시킨다.
		 */
		if(n==p&&arr[n-1]>=score) {
			System.out.println(-1);
			System.exit(0);
		}
		
		// 이외의 경우라면 자신의 랭킹을 구한다.
		int rank=1;
		for(int i=0;i<n;i++) 
			if(arr[i]>score)
				rank++;
			else
				break;
	
		System.out.println(rank);
	}

}
