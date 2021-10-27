import java.util.*;

class Command {
	int num;
	String result; // num이라는 숫자가 도출되기 까지 수행한 연산
	
	public Command(int num, String result) {
		this.num=num;
		this.result=result;
	}
}
public class BaekJoon_9019 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		
		while(tc-->0) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			boolean[] visited=new boolean[10000]; // 각 숫자가 만들어졌는지 체크하는 배열
			visited[a]=true; // 시작 숫자인 a는 true 처리
			
			Queue<Command> q=new LinkedList<>();
			q.offer(new Command(a,""));
			
			while(!q.isEmpty()) {
				Command c=q.poll();
				int now=c.num;
				// 각 연산
				int D=(now*2)%10000;
				int S=(now==0)?9999:now-1;
				int L=(now%1000)*10+now/1000;
				int R=(now%10)*1000+now/10;
				
				if(now==b) { // 정답 숫자가 나왔다면 해당 숫자가 도출되기까지 수행한 연산들을 저장한 문자열 출력 후 종료
					System.out.println(c.result);
					break;
				}
				
				/*
				 * 각 연산을 수행한 결과가 한번도 도출된 적 없는 값이라면
				 * 해당 값을 방문처리 해준 후 큐에 값과, 이전 값(now)를 얻고자 수행한 연산들(c.result)에 
				 * 수행한 연산을 더한 값을 삽입한다. 
				 */
				if(!visited[D]) {
					visited[D]=true; 
					q.offer(new Command(D,c.result+"D"));
				}
				
				if(!visited[S]) {
					visited[S]=true;
					q.offer(new Command(S,c.result+"S"));
				}
				
				if(!visited[L]) {
					visited[L]=true;
					q.offer(new Command(L,c.result+"L"));
				}
				
				if(!visited[R]) {
					visited[R]=true;
					q.offer(new Command(R,c.result+"R"));
				}
			}
		}
	}
}
