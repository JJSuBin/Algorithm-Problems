import java.io.*;
import java.util.*;

public class BaekJoon_10866 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 
		ArrayDeque<Integer> dq=new ArrayDeque<Integer>();
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		
		for (int i=0;i<n;i++) {
			 
			String[] s=br.readLine().split(" ");
 
			switch(s[0]) {
				// push_front X : 정수 X를 덱의 앞에 넣는다.
				case "push_front": {
					dq.addFirst(Integer.parseInt(s[1]));
					break;
				}
				
				// push_back X : 정수 X를 덱의 뒤에 넣는다.
				case "push_back": {
					dq.addLast(Integer.parseInt(s[1]));
					break;
				}
				/*
				 * pop_front : 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 
				 * 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다. 
				 */
				case "pop_front": {
					if (dq.isEmpty()) {
						sb.append(-1).append('\n');
					} 
					else {
						sb.append(dq.pollFirst()).append('\n');
					}
					break;
				}
 
				/*
				 * pop_back : 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 
				 * 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				 */
				case "pop_back": {
					if (dq.isEmpty()) {
						sb.append(-1).append('\n');
					} 
					else {
						sb.append(dq.pollLast()).append('\n');
					}
					break;
				}
				
				// size : 덱에 들어있는 정수의 개수를 출력한다.
				case "size": {
					sb.append(dq.size()).append('\n');
					break;
				}
				
				// empty : 덱이 비어있으면 1을, 아니면 0을 출력한다.
				case "empty": {
					if (dq.isEmpty()) {
						sb.append(1).append('\n');
					} 
					else {
						sb.append(0).append('\n');
					}
					break;
				}
				
				// front : 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				case "front": {
					if (dq.isEmpty()) {
						sb.append(-1).append('\n');
					} 
					else {
						sb.append(dq.peekFirst()).append('\n');
					}
					break;
				}
				
				// back : 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				case "back": {
					if (dq.isEmpty()) {
						sb.append(-1).append('\n');
					} 
					else {
						sb.append(dq.peekLast()).append('\n');
					}
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
