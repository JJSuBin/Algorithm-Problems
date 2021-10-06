import java.util.*;

public class BaekJoon_1956 {
	static int[][] graph;
	static int v,e,min=Integer.MAX_VALUE;
	static final int INF=(int)1e9;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		v=sc.nextInt();
		e=sc.nextInt();
		
		graph=new int[v+1][v+1];
		
		// 그래프 초기화
		for(int i=0;i<=v;i++)
			Arrays.fill(graph[i],INF);
		
		// 간선 정보
		for(int i=0;i<e;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			// 단방향 그래프
			graph[a][b]=Math.min(graph[a][b],c);
		}
		
		// 플로이드 와샬 알고리즘
		for(int k=1;k<=v;k++)
			for(int i=1;i<=v;i++)
				for(int j=1;j<=v;j++)
					graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
		
		/*
		 * 이번 문제는 싸이클을 찾는 것이기 때문에
		 * a마을에서 다시 a마을로 돌아오는 경우를 찾아야 한다. 
		 * 이러한 경우는 그래프의 행과 열이 같은 배열 값에 저장되어 있다. 
		 */
		for(int i=1;i<=v;i++)
			min=Math.min(min, graph[i][i]);
		
		if(min==INF)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}
