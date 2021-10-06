import java.util.*;

public class BaekJoon_15655 {
	static int n,m;
	static int[] num;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		num=new int[n];
		visited=new boolean[n];
		
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();
		
		// 수열이 오름차순이도록 정렬한 배열 사용
		Arrays.sort(num);
		
		backtarcking(0,0);
	}

	static void backtarcking(int depth, int start) {
		// 선택한 숫자의 개수가 m개라면, 선택된 숫자들만 출력
		if(depth==m) {
			for(int i=0;i<n;i++) {
				if(visited[i])
					System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		
		// 백트래킹
		for(int i=start;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				// 중복되는 숫자를 선택하지 않기 위해 재귀호출의 for문 시작을 i+1로 지정
				backtarcking(depth+1,i+1);
				visited[i]=false;
			}
		}
	}
}
