import java.util.*;

public class BaekJoon_1343 {
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		int count=0;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='.') {
				// count가 짝수라면 덮어쓸 수 있는 경우
				if(count%2==0) {
					cover(count);
					count=0;
				}
				
				// count가 홀수라면 덮어쓸 수 없는 경우이므로 -1 출력 후 종료
				else {
					System.out.println(-1);
					System.exit(0);
				}
				
				// 덮어쓰기가 끝났다면 . 추가 
				sb.append('.');
			}
			
			// X 개수 count
			else
				count++;
		}
		
		// 문자열의 끝에 X가 있는 경우 처리 
		if(count%2==0) 
			cover(count);
		else {
			System.out.println(-1);
			System.exit(0);
		}
		
		System.out.println(sb);
	}
	
	// 덮어쓰기 함수
	static void cover(int count) {
		int length=count/4;
		
		// count를 4로 나눈 몫 만큼 AAAA 덮어쓰기
		for(int i=0;i<length;i++)
			sb.append("AAAA");
		
		length=count%4;
		
		// 4로 나눠 떨어지지 않는다면 반드시 남은 count는 2이기 때문에 BB 한번 덮어쓰기
		if(length!=0)
			sb.append("BB");
	}
}

/*
 public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		// 사전순으로 앞서는 답을 출력해야 하기 때문에 AAAA를 먼저 치환
		str=str.replaceAll("XXXX", "AAAA"); // XXXX -> AAAA로 변경
		str=str.replaceAll("XX", "BB"); // XX -> BB로 변경 
		
		
		// 위의 과정을 수행 후에도 X가 남아있다면 덮을 수 없는 문자열
		if(str.contains("X"))
			System.out.println(-1);
		else
			System.out.println(str);
	} 
	
*/
  
 
