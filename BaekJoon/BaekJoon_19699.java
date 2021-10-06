import java.util.*;

public class BaekJoon_19699 {
	static HashSet<Integer> set=new HashSet<>();
	static int n,m;
	static boolean[] visited;
	static int[] weight;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		weight=new int[n];
		visited=new boolean[n];
		
		for(int i=0;i<n;i++)
			weight[i]=sc.nextInt();
		
		dfs(0,0,0);
		
		// 정렬을 위해 HashSet의 데이터를 연결리스트에 복산
		ArrayList<Integer> result=new ArrayList<>(set);
		Collections.sort(result); // 정렬
		
		// 소들의 몸무게 합으로 만들 수 있는 소수가 없는 경우
		if(result.size()==0)
			System.out.println(-1);
		// 소들의 몸무게 합으로 만들 수 있는 소수가 있다면 출력
		else {
			for(int i=0;i<result.size();i++)
				System.out.print(result.get(i)+" ");
		}
	}
	
	// 백트래킹
	static void dfs(int depth, int sum, int start) {
		// m마리의 소를 선택했다면 몸무게의 합이 소수인지 판별
		if(depth==m) {
			if(isPrime(sum))
				set.add(sum); // 몸무게의 합이 소수라면 HashSet에 몸무게 삽입 
			return;
		}
		
		// 중복된 경우의 수를 제거하기 위해 start 부터 탐색
		for(int i=start;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(depth+1,sum+weight[i],i+1);
				visited[i]=false;
			}
		}
	}
	
	// 에라토스테네스의 채로 소수 판별
	static boolean isPrime(int num) {
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0)
				return false;
		}
		return true;
	}
}
