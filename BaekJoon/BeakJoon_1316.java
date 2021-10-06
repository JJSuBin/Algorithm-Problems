import java.util.*;

public class BeakJoon_1316 {
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		int n=sc.nextInt();
		int count=0;
		
		for(int i=0;i<n;i++) {
			if(check()==true) 
				count++;
		}
		
		System.out.println(count);
	}

	public static boolean check() {
		boolean[] check=new boolean[26];
		String str=sc.next();
		int prev=0;
		
		for(int i=0;i<str.length();i++) {
			int now=str.charAt(i);
			// 이전 문자와는 다른 문자이며,
			if(prev!=now) {
				// 나온적 없는 문자이면
				if(check[now-'a']==false) {
					check[now-'a']=true; // 배열 값 변경
					prev=now; // 이전 값 갱신
				}
				
				// 이전에 나온 문자이면 false 반환
				else 
					return false;
			}
		}
		return true;
	}
}
