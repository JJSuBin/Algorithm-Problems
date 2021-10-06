import java.util.*;

public class BaekJoon_14391 {
	static boolean[][] visited;
	static int[][] map;
	static int n,m,max=Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map=new int[n][m];
		visited=new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String str=sc.next();
			for(int j=0;j<m;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		check(0,0);
		System.out.println(max);
	}
	
	/*
	 * 가로로 더해야 하는 숫자와, 세로로 더해야 하는 숫자를 각각 true/false로 나타내는 함수
	 * 각 배열의 값이 true일수 있는 경우와 false일 수 있는 경우가 있기 때문에 
	 * 모든 배열의 값이 이룰 수 있는 경우의 수를 백트래킹으로 탐색한다. 
	 */
	static void check(int r, int c) {
		// 마지막 행에 도달했다면 해당 경우의 가로, 세로합을 구한다.
		if(r>=n) {
			sum();
			return;
		}
		
		// 하나의 열이 true/false 표시가 완료됐다면 다음 행으로 넘어간다.
		if(c>=m) {
			check(r+1,0);
			return;
		}
		
		visited[r][c]=true; // 가로 숫자에 포함하고, 다음 열로 넘어간다.
		check(r,c+1);
		
		/*
		 * 여기서 다시 visied 배열을 값을 되돌리기 때문에 
		 * 각 경우마다 visited 배열을 초기화 해 줄 필요가 없다.
		 */
		visited[r][c]=false; // 세로 숫자에 포함하고, 다음 열로 넘어간다.
		check(r,c+1);
	}
	
	static void sum() {
		int sum=0; // 한 경우의 가로, 세로 숫자의 합
		
		// 가로 숫자 더하기
		for(int i=0;i<n;i++) {
			int temp=0;
			for(int j=0;j<m;j++) {
				// visited 값이 true인 경우는 가로 숫자에 해당
				if(visited[i][j]) {
					temp*=10; // 자릿수 밀기
					temp+=map[i][j]; // 해당 숫자 일의 자리에 더하기
				}
				/*
				 * visited 값이 false를 만난다면 세로 숫자에 해당하기 때문에 
				 * 이전까지 구해진 가로 숫자를 더하고 temp 초기화
				 */
				else {
					sum+=temp;
					temp=0;
				}
			}
			
			sum+=temp; // 한 행이 모두 가로숫자에 포함되는 수라면 여기서 더해주어야 한다.
		}
		
		// 세로 숫자 더하기
		for(int i=0;i<m;i++) {
			int temp=0;
			for(int j=0;j<n;j++) {
				// visited 값이 false인 경우는 세로 숫자에 해당
				if(!visited[j][i]) {
					temp*=10; // 자릿수 밀기
					temp+=map[j][i]; // 일의 자리에 더하기
				}
				/*
				 * visited 값이 true를 만난다면 가로 숫자에 해당하기 때문에 
				 * 이전까지 구해진 세로 숫자를 더하고 temp 초기화
				 */
				else {
					sum+=temp;
					temp=0;
				}
			}
			sum+=temp; // 한 열이 모두 세로숫자에 포함되는 수라면 여기서 더해주어야 한다.
		}
		
		max=Math.max(max, sum); // 최댓값 갱신
	}
}
