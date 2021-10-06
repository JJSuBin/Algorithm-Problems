import java.util.*;

public class BaekJoon_5052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			int n=sc.nextInt();
			String[] phone_number=new String[n];
			
			for(int i=0;i<n;i++) 
				phone_number[i]=sc.next();
			
			Arrays.sort(phone_number); // 오름차순으로 정렬
			
			// 접두어 관계가 없다면 YES 출력, 없다면 NO 출력
			if(check(n,phone_number))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	// 전화번호 목록이 일관성을 유지하는지 확인하는 함수
	public static boolean check(int n, String[] phone_number) {
		/*
		 * phone_number 배열은 오름차순으로 정렬되어 있는 상태이다. 
		 * 만약 전화번호 목록 내에 접두어 관계가 있는 문자열이 있다면
		 * 배열의 다음 인덱스에 접두어 관계가 있는 문자열이 배치될 것이다. 
		 * 따라서 전화번호 목록이 일관성을 유지하는지 확인하기 위해서는
		 * 특정 문자열과 그 다음 문자열이 접두어 관계를 확인하면 된다. 
		 */
		for(int i=0;i<n-1;i++) {
			if(phone_number[i+1].startsWith(phone_number[i]))
				return false;
		}
		return true;
	}
}
