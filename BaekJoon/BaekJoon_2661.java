import java.util.Scanner;

public class BaekJoon_2661 {
	public static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		dfs("");
	}

	public static void dfs(String num) {
		/*
		 * 만들어진 문자열의 길이가 n과 같아지면 
		 * 해당 문자열을 출력하고 프로그램을 강제종료 한다.
		 * 뮨자열은 1~3 순서대로 숫자가 추가되기 때문에 
		 * 제일 먼저 n 길이로 만들어진 문자열이 가장 작은 숫자가 된다.
		 */
		if(num.length()==n) {
			System.out.println(num);
			System.exit(0);
		}
		
		// 백트래킹
		for(int i=1;i<=3;i++) {
			// 만들어진 문자열이 좋은 수열이라면 재귀호출
			if(check(num+i))
					dfs(num+i);
		}
	}
	
	/*
	 * 해당 문자열이 좋은 수열인지 판단하는 함수
	 * 길이가 n인 수열에서 인접하면서 동일한 수열이 만들어질 수 있는 경우는
	 * 수열의 길이가 최소 1부터 최대 n/2인 경우 발생한다.
	 * 
	 * 따라서 앞의 n/2개의 수와 뒤의 n/2수가 동일한지 비교하여
	 * 좋은 수열인지 판별할 수 있다.
	 */
	public static boolean check(String str) {
		for(int i=1;i<=str.length()/2;i++) {
			String front_str=str.substring(str.length()-i-i,str.length()-i);
			String back_str=str.substring(str.length()-i,str.length());
			
			if(front_str.equals(back_str))
				return false;
		}
		return true;
	}
}
