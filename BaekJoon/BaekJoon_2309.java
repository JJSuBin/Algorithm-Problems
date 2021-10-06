import java.util.*;

public class BaekJoon_2309 {
	public static int[] dwarf=new int[9]; // 9명의 난쟁이 키 저장 배열
	public static boolean[] visited=new boolean[9]; // 방문 여부 체크 배열
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<9;i++)
			dwarf[i]=sc.nextInt();
		
		Arrays.sort(dwarf);
		
		dfs(0,0);
	}
	public static void dfs(int start, int depth) {
		// 방문한 난쟁이의 수가 7명이 됐을 경우
		if(depth==7) {
			int sum=0; // 키 누적 합 저장 변수
			StringBuilder sb=new StringBuilder();
			
			// 9명의 난쟁이 중 방문처리 된 7명의 난쟁이의 키의 합을 구한다.
			for(int i=0;i<9;i++) {
				if(visited[i]) {
					sb.append(dwarf[i]).append("\n");
					sum+=dwarf[i];
				}
			}
			
			/*
			 * 키의 합이 100이 된 경우가 나올 경우 
			 * 저장한 난쟁이들의 키를 출력한 후 시스템을 종료한다.
			 */
			if(sum==100) {
				System.out.println(sb.toString());
				System.exit(0);
			}
		}
		
		// 백트래킹
		for(int i=start;i<9;i++) {
			visited[i]=true; // 방문처리
			dfs(i+1,depth+1); // 선택한 난쟁이의 수(depth)를 1 증가시기고 재귀호출
			// 재귀호출을 끝내고 다음 연산을 위해 방문 배열의 값을 되돌린다.
			visited[i]=false;
		}
	}
}
