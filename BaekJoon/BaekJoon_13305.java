import java.util.*;

/*
 * 알고리즘
 * 최소비용으로 가기 위한 방법은 리터당 기름 값이 내림차순일 경우에 주유하는 것이다.
 * 예를들어 5 2 4 1인 경우 5 다음 2는 내림차순이기 때문에 주유하지만
 * 그 다음인 4는 내림차순이 아니기 때문에 그 이전의 값인 2로 주유해야 한다. 
 */
public class BaekJoon_13305 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		long[] distance=new long[n-1];
		long[] cost=new long[n];
		
		for(int i=0;i<n-1;i++)
			distance[i]=sc.nextLong();
		
		for(int i=0;i<n;i++)
			cost[i]=sc.nextLong();
		
		long sum=0;
		long mincost=cost[0]; // 처음에는 무조건 기름을 넣어야 하기 때문에 초기값으로 설정
		
		// 지나야 하는 거리의 개수만큼 for문 실행
		for(int i=0;i<n-1;i++) {
			
			// 현재 주유소가 이전 주유소의 기름값보다 쌀 경우 minCost를 갱신
			if(cost[i]<mincost)
				mincost=cost[i];
			
			// 거리*리터당 기름 값 계산
			sum+=(mincost*distance[i]);
		}
		System.out.println(sum);
	}
}
