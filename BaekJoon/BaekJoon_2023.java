import java.util.*;

public class BaekJoon_2023 {
	static int n,count=0;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		dfs(0,"");
		System.out.println(sb);
	}
	
	static void dfs(int depth, String num) {
		// n의 자리가 만들어졌다면 추가
		if(depth==n) {
			sb.append(num).append('\n');
			return;
		}
		
		// 1~9까지 소수인지 판별하여 소수라면 문자열 뒤에 붙이고 재귀호출
		for(int i=1;i<=9;i++) {
			if(isPrime(Integer.parseInt(num+i)))
				dfs(depth+1,num+i);
		}
	}
	
	/*
	 * <에라토스테네스 알고리즘>
	 * 2부터 루트n 이하까지 반복하여 n과 나누어 떨어지는 숫자가 있다면 소수가 아님
	 */
	public static boolean isPrime(int n) {
        // 1은 소수가 아니기 때문에 바로 false 처리
		if(n==1)
        	return false;
		
		for(int i=2;i<=Math.sqrt(n);i++) {
        	if(n%i==0)
        		return false;
        }
        
        return true;
	}
}
