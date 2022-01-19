import java.io.*;
import java.util.*;

public class BaekJoon_10845 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
				
		Queue<Integer> q=new LinkedList<>();
		int back_num=-1; // 가장 마지막에 삽입된 값 저장 변수
		
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
					
			// 큐의 각 함수에 맞는 결과 처리
			switch(st.nextToken()) {
			case "push": // 값 삽입
				// 가장 마지막에 삽입된 값은 "back" 연산을 위해 계속 가져간다.
				back_num=Integer.parseInt(st.nextToken());
				q.add(back_num);
				break;
						
			case "pop": // 값 삭제
				if(q.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(q.poll()).append('\n');
				break;
						
			case "size": // 큐의 크기 반환
				sb.append(q.size()).append('\n');
				break;
						
			case "empty": // 큐이 비었는가 여부 판단
				if(q.isEmpty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
				break;
					
			case "front": // 큐의 맨 앞의 값 반환(값 삭제 X)
				if(q.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(q.peek()).append('\n');
				break;
			
			case "back": // 큐의 맨 뒤의 값 반환(값 삭제 X)
				if(q.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(back_num).append('\n');
				break;
			}
		}
		System.out.println(sb);

	}

}
