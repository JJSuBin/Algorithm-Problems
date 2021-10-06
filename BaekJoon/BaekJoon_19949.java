import java.util.Scanner;

public class BaekJoon_19949 {
	static int result=0;
	static int[] score=new int[10];
	static int[] choice=new int[10];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		// 각 문제의 정답 저장
		for(int i=0;i<10;i++)
			score[i]=sc.nextInt();

		dfs(0);
		System.out.println(result);
	 }
	
	static void dfs(int depth) {
		// 10 문제 모두 답을 선택했다면 점수 계산
		if(depth==10) {
			int sum=0;
			for(int i=0;i<10;i++) {
				if(score[i]==choice[i])
					sum++;
			}
			// 5점이 넘었다면 경우의 수 count
			if(sum>=5)
				result++;
			
			return;
		}
		
		for(int i=1;i<6;i++) {
			/*
			 * 이전 두 문제와 답이 같으면 안되기 때문에 
			 * 두 문제 이상으로 푼 경우에 이전 문제와 그 이전 문제와 답이 같은 경우는 넘어간다. 
			 */
			if(depth>1&&choice[depth-1]==i&&choice[depth-2]==i)
				continue;
			
			choice[depth]=i; // 5지선다형 중 하나 선택
			dfs(depth+1); // 재귀호출
			choice[depth]=0; // 값 초기화
		}
	}

}
