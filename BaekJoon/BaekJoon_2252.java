import java.io.*;
import java.util.*;

public class BaekJoon_2252 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int[] indegree=new int[n+1]; // 진입 차수 테이블
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
		for(int i=0;i<=n;i++)
			graph.add(new ArrayList<>());
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			indegree[b]++;
		}
		
		// 위상정렬 -> 선후관계가 정의된 그래프 구조에서 정렬을 하기 위해 사용
		Queue<Integer> q=new LinkedList<>();
		Queue<Integer> result=new LinkedList<>();
		
		// indegree가 0인 노드 큐에 삽입
		for(int i=1;i<=n;i++)
			if(indegree[i]==0)
				q.offer(i);
		
		while(!q.isEmpty()) {
			int now=q.poll();
			result.add(now);
			
			for(Integer next:graph.get(now)) {
				indegree[next]--; // 진입 차수 감소
				
				// 진입 차수가 0이 된다면 큐에 삽입
				if(indegree[next]==0)
					q.add(next);
			}
		}
		
		while(!result.isEmpty())
			System.out.print(result.poll()+" ");
	}

}
