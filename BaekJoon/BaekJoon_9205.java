import java.util.*;

class Point_9205 {
	int x,y;
	
	public Point_9205(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class BaekJoon_9205 {
	static StringBuilder sb=new StringBuilder();
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<Point_9205> position; // 집, 편의점(n개), 페스티벌 위치 저장
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			int n=sc.nextInt(); // 편의점 개수 -> 모든 장소는 n+2(집,페스티벌)
			
			// 각 장소의 좌표 저장
			position=new ArrayList<Point_9205>();
			for(int i=0;i<n+2;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				
				position.add(new Point_9205(a,b));
			}
			
			graph=new ArrayList<ArrayList<Integer>>();
			// 집, 페스티벌 장소, n개의 편의점 노드 생성
			for(int i=0;i<n+2;i++)
				graph.add(new ArrayList<>());
			
			/*
			 * 1병당 50m를 갈 수 있는 맥주의 개수는 20개이기 때문에 이동할 수 있는 거리는 50m*20=1000m이다. 
			 * 따라서 다음 장소의 거리가 1000m 이내라면 갈 수 있는 장소이기 때문에 그래프상에서 연결시켜준다.
			 */
			for(int i=0;i<n+2;i++) {
				for(int j=i+1;j<n+2;j++) {
					// 갈 수 있는 장소라면 
					if(Pentaford(position.get(i),position.get(j))<=1000) {
						// 양방향
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			// 결과 저장
			sb.append((bfs(n))?"happy":"sad").append('\n');
		}
		
		System.out.println(sb);
	}
	
	// 거리 구하는 함수
	static int Pentaford(Point_9205 p1, Point_9205 p2) {
		return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
	}
	
	static boolean bfs(int n) {
		Queue<Integer> q=new LinkedList<>();
		q.offer(0); // 시작은 집
		
		boolean[] visited=new boolean[n+2];
		visited[0]=true; // 방문처리
		
		while(!q.isEmpty()) {
			int now=q.poll();
			
			// 마지막 페스티벌 장소까지 이동했다면 true를 return
			if(now==n+1)
				return true;
			
			// 시작 지점으로부터 연결되어 있는 다른 장소로 이동
			for(int next:graph.get(now)) {
				// 방문하지 않았다면 방문처리 해준 후, 큐에 삽입
				if(!visited[next]) {
					visited[next]=true;
					q.offer(next);
				}
			}
		}
		// 마지막 장소까지 도달하지 못했다면 false를 return
		return false;
	}
}
