import java.util.*;

public class BaekJoon_12101 {
	static ArrayList<String> arr=new ArrayList<>();
	static int n,k,count=0;
	static boolean flag=false;
	static int[] choice;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		choice=new int[n];
		
		dfs(0,0);
		
		// k번째에 오는 식이 없다면 -1 출력
		if(!flag)
			System.out.println(-1);
	}
	
	static void dfs(int depth, int sum) {
		// 수의 누적 합이 n을 초과할 경우 넘어간다.
		if(sum>n)
			return;
		
		// 수의 누적 합이 n일 경우
		if(sum==n) {
			count++; // 갯수 증가
			
			// 합쳐서 n이 되는 식의 개수가 k번째라면
			if(count==k) {
				flag=true;
				// 식 출력
				for(int i=0;i<depth-1;i++) {
					System.out.print(choice[i]+"+");
				}
				System.out.print(choice[depth-1]);
			}
			return;
		}
		
		// 백트래킹
		for(int i=1;i<=3;i++) {
			choice[depth]=i; // dpeth 번째에 1~3 중 선택
			dfs(depth+1,sum+i); // 깊이를 1 증가시키고, 수의 합에 i를 더한 후 재귀호출
		}
	}
}
