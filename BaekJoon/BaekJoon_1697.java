import java.util.*;

public class BaekJoon_1697 {
	public static int n,k;
	public static int[] subin=new int[100001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		
		if(n==k)
			System.out.println(0);
		else
			bfs(n);
	}
	
	public static void bfs(int start) {
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(start);
		subin[start]=0;
		
		while(!q.isEmpty()) {
			int now=q.poll();
			
			// 3가지 경우 탐색
			for(int i=0;i<3;i++) {
				int next;
				
				if(i==0)
					next=now+1;
				else if(i==1)
					next=now-1;
				else
					next=now*2;
				
				// 다음 위치가 k와 같다면 이전 값에 마지막 경우 +1 해준 값을 출력 후 return 
				if(next==k) {
					System.out.println(subin[now]+1);
					return;
				}
				
				/*
				 * 다음 위치가 이동 가능한 범위 내에 있고,
				 * 방문하지 않았다면 큐에 삽입 후 이전 일수에서 +1해준 값으로 갱신한다.
				 * 
				 * 이때 이미 방문한 위치라면 탐색하지 않는 이유는 
				 * 큐는 선입선출 자료구조이기 때문에 이전에 이미 방문했다면
				 * 해당 위치에 먼저 도착한 경우가 무조건 빠르거나 같기 때문이다.
				 */
				if(0<=next&&next<subin.length&&subin[next]==0) {
					q.offer(next);
					subin[next]=subin[now]+1;
				}
			}
		}
	}
}
