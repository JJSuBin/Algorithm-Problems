import java.util.*;

public class BaekJoon_5430 {
	static StringBuilder sb = new StringBuilder();
	static Scanner sc=new Scanner(System.in);
	static StringTokenizer st;
	public static void main(String[] args) {
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			String command=sc.next();
			int n=sc.nextInt();
			
			// [] 안에 입력받은 숫자들을 []와 , 구분자를 기준으로 분리한다.
			st=new StringTokenizer(sc.next(),"[],");
			ArrayDeque<Integer> deq=new ArrayDeque<>();
			
			// 덱에 분리한 숫자들을 삽입
			for(int i=0;i<n;i++)
				deq.add(Integer.parseInt(st.nextToken()));
			
			AC(command,deq);
		}
		System.out.println(sb);
	}
	
	// 
	public static void AC(String command, ArrayDeque<Integer> deq) {
		/*
		 * 현재 덱의 출력 위치가 덱의 앞인지 뒤인지 판별하는 변수
		 * true면 덱이 뒤집힌것 처럼 뒤쪽을 가리키고, false면 덱의 원래 상태인 앞을 가리킨다. 
		 */
		boolean reverse=false; 
		
		for(int i=0;i<command.length();i++) {
			char ch=command.charAt(i);
			
			// R 명령일 경우 : 배열에 있는 숫자의 순서를 뒤집는 함수
			if(ch=='R') {
				reverse=!reverse; 
				continue;
			}
			
			// D 명령일 경우 : 첫 번째 숫자를 버리는 함수
			else {
				// 숫자의 순서가 뒤집혀 있다면
				if(reverse==true) {
					/*
					 * 덱의 맨 뒷 숫자가 맨 앞 숫자가 되는 것이기 때문에
					 * pollLast() 함수로 덱의 맨 뒷 숫자를 제거한다. 
					 * 이때 덱에 제거할 수 있는 숫자가 없다면 error를 출력하고 종료한다.
					 */
					if(deq.pollLast()==null) {
						sb.append("error\n");
						return;
					}
				}
				// 숫자의 순서가 뒤집혀 있지 않다면
				else {
					/*
					 * 덱의 맨 앞 숫자를 제거하면 되기 때문에 
					 * pollFirst() 함수로 덱의 맨 앞 숫자를 제거한다. 
					 * 이때 덱에 제거할 수 있는 숫자가 없다면 error를 출력하고 종료한다.
					 */
					if(deq.pollFirst()==null) {
						sb.append("error\n");
						return;
					}
				}
			}
		}
		
		Print(deq,reverse);
	}
	
	// 연산이 끝난 결과를 출력하는 함수 
	public static void Print(ArrayDeque<Integer> deq, boolean reverse) {
		sb.append('['); // 괄호 시작
		
		// 덱에 숫자가 저장되어 있다면
		if(deq.size()>0) {
			// 배열이 뒤집혀 있는 경우 -> 덱의 뒤에서부터 출력
			if(reverse==true) {
				sb.append(deq.pollLast()); // 첫 번쨰 원소부터 저장
				
				// 다음 원소부터 콤마 뒤에 숫자를 붙여 출력
				while(!deq.isEmpty()) 
					sb.append(',').append(deq.pollLast());
			}
			// 배열이 뒤집혀 있지 않은 경우 -> 덱의 앞에서부터 출력
			else {
				sb.append(deq.pollFirst()); // 첫 번쨰 원소부터 저장
				
				// 다음 원소부터 콤마 뒤에 숫자를 붙여 출력
				while(!deq.isEmpty()) 
					sb.append(',').append(deq.pollFirst());
			}
		}
		sb.append(']').append('\n'); // 괄호 종료
	}
}
