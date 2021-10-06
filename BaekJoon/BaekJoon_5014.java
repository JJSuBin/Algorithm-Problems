import java.util.*;

public class BaekJoon_5014 {
	static int f,s,g,u,d;
	static int[] visited; // 각 층수의 방문 여부와, 방문 횟수를 확인하는 배열
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		f=sc.nextInt(); // 건물 높이 
		s=sc.nextInt(); // 강호의 위치
		g=sc.nextInt(); // 스타트링크 위치
		u=sc.nextInt(); // 한번 누를때 올라가는 층수
		d=sc.nextInt(); // 한번 누를때 내려가는 층수
		
		visited=new int[f+1];
		
		System.out.println(bfs(s));
	 }
	
	static String bfs(int start) {
		Queue<Integer> q=new LinkedList<>();
		/*
		 * 시작 층수의 값은 방문처리를 위해 값을 1로 변경한다.
		 * 이후 방문 횟수는 시작 배열 값에서 누적합으로 구하기 때문에 
		 * 버튼을 누르지 않았지만 방문처리를 위해 시작 층수에 +1을 해준 값으로 인해
		 * 최종 값에서 -1 해주어야 한다.  
		 */
		visited[start]=1;  
		q.offer(start);
		
		while(!q.isEmpty()) {
			int now=q.poll();
			
			// 큐에서 뺀 값이 도착 층수와 같다면 해당 방문 횟수에서 초기값 -1 해준 값을 return
			if(now==g) {
				return String.valueOf(visited[now]-1);
			}
			
			// 현재 층수에서 u간 올라간 층수가 범위 내에 있고, 방문하지 않았다면
			if(now+u<=f&&visited[now+u]==0) {
				visited[now+u]=visited[now]+1; // 이전 방문 횟수에 +1한 값을 저장
				q.offer(now+u); // 위치를 큐에 삽입
			}
			
			// 현재 층수에서 d칸 내려간 층수가 범위 내에 있고, 방문하지 않았다면
			if(now-d>0&&visited[now-d]==0) { 
				visited[now-d]=visited[now]+1; // 이전 방문 횟수에 +1한 값을 저장
				q.offer(now-d); // 위치를 큐에 삽입
			}
		}
		
		// g층에 갈 수 없다면 "use the stairs" return
		return "use the stairs";
	}
}
