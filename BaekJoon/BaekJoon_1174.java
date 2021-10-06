import java.util.*;

public class BaekJoon_1174 {
	static int[] num= {9,8,7,6,5,4,3,2,1,0};
	static ArrayList<Long> arr=new ArrayList<>();
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		dfs(0,0);
		Collections.sort(arr); // n번째 수를 찾기 위해 정렬한다.
		
		/*
		 * 숫자는 겹치게 선택할 수 없기 때문에 
		 * 10개의 숫자를 선택하냐 선택하지 않느냐 총 1024개의 경우의 수가 나온다.
		 * 이 수를 넘어가는 n을 입력받는다면 n번째로 작은 줄어드는 수가 존재할 수 없기 때문에 -1을 출력한다.
		 */
		if(n>1023)
			System.out.println(-1);
		else
			System.out.println(arr.get(n-1));
	}
	
	static void dfs(long sum, int index) {
		// sum이 이전에 나온적이 없는 수라면 arr에 저장
		if(!arr.contains(sum))
			arr.add(sum);
		
		// num 배열로 모두 탐색했다면 재귀호출 종료
		if(index>=10)
			return;
		
		/*
		 * num 배열의 현재 수를 선택 하느냐, 선택하지 않느냐 
		 * 두 가지 경우만 존재하므로 각각의 경우 모두 재귀호출 해주면 된다.  
		 */
		dfs(sum*10+num[index],index+1); // 현재 수를 선택하는 경우
		dfs(sum,index+1); // 현재 수를 선택하지 않는 경우
	}
}
