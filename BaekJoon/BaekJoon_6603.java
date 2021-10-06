import java.util.*;

public class BaekJoon_6603 {
	static boolean[] visited=new boolean[50];
	static int k;
	static int[] num;
	public static void main(String[] args) {		
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			k=sc.nextInt();
			
			// 0을 입력받으면 프로그램 종료
			if(k==0)
				System.exit(0);
			
			// 로또 숫자 입력 받기
			num=new int[k];
			for(int i=0;i<k;i++)
				num[i]=sc.nextInt();
			
			dfs(0,0);
			// 각 테스트케이스 마다 한 줄 띄기
			System.out.println(); 
		}
	}
	
	// 백트래킹
	public static void dfs(int depth, int start) {
		// 숫자를 6개를 선택했다면
		if(depth==6) {
			for(int i=0;i<k;i++) {
				// 방문처리 된 숫자들만 출력
				if(visited[i]==true)
					System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		
		// 백트래킹
		for(int i=start;i<k;i++) {
			visited[i]=true; // 방문처리
			/*
			 * 중복된 숫자를 선택할 수 없기 때문에 
			 * 재귀호출을 할 경우 i+1 부터 탐색을 해야한다.  
			 */
			dfs(depth+1,i+1);
			// 재귀호출이 끝난다면 다음 경우의 수를 위해 값을 되돌린다.
			visited[i]=false;
		}
	}
}
