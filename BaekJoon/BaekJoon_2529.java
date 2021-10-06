import java.util.*;

public class BaekJoon_2529 {
	public static boolean[] visited=new boolean[10];
	public static char[] sign;
	public static int k,min=Integer.MAX_VALUE;
	public static ArrayList<String> result=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		k=sc.nextInt();
		sign=new char[k];
		
		for(int i=0;i<k;i++)
			sign[i]=sc.next().charAt(0);
		
		dfs(0,"");
		
		Collections.sort(result);
		System.out.println(result.get(result.size()-1)); // 가장 큰 숫자
		System.out.println(result.get(0)); // 가장 작은 숫자
	}
	
	public static void dfs(int depth, String num) {
		/*
		 * 부등호가 k개라면 숫자는 k+1개이기 때문에
		 * 깊이가 숫자의 개수와 같아지면 결과를 result에 저장하고 return 
		 */
		if(depth==k+1) {
			result.add(num);
			return;
		}
		
		for(int i=0;i<=9;i++) {
			// 사용했던 숫자가 아니라면
			if(visited[i]==false) {
				/*
				 * 부등호 조건을 만족하거나, 깊이가 0인 경우도 아래 문장 수행
				 * 이때 깊이가 0일 경우에는 부등호 조건의 참/거짓 여부를 판단할 수 없기 때문에
				 * 아래 조건을 반드시 수해해야 하는 depth==0인 경우를 반드시 명시해주어야 한다.
				 */
				if(depth==0||check(Character.getNumericValue(num.charAt(depth-1)),i,sign[depth-1])) {
					visited[i]=true;
					dfs(depth+1,num+Integer.toString(i));
					visited[i]=false;
				}
			}
		}
	}
	
	// 부등호 조건을 만족하지는 검사하는 함수
	public static boolean check(int a, int b, char c) {
		if(c=='>') 
			if(a<b)
				return false;
		
		if(c=='<')
			if(a>b)
				return false;
		
		return true;
	}
}
