import java.util.*;

public class BaekJoon_1525 {
	/*
	 * key 값에는 퍼즐을 정수로 나타낸 값이 저장되며, 
	 * value 값에는 해당 정수를 만들기까지 퍼즐의 이동 횟수가 저장된다. 
	 */
	static Map<Integer,Integer> map=new HashMap<>();
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		/*
		 * 2차원의 배열로 주어지는 퍼즐을 일렬로 주어지는 숫자처럼 생각하는 것이 편하다.
		 * 따라서 아래 과정을 통해 9자리의 정수로 나타낸다.
		 */
		int start=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int num=sc.nextInt();
				if(num==0)
					num=9;
				
				start=(start*10)+num;
			}
		}
		
		map.put(start,0); 
		bfs(start);
		
		// 제대로 맞춰진 123456789가 저장되어 있다면 이동 횟수 출력
		if(map.containsKey(123456789))
			System.out.println(map.get(123456789));
		// 퍼즐이 맞춰지지 않았다면 -1 출력
		else
			System.out.println(-1);
	}
	
	/*
	 * 퍼즐의 0을 9로 바꿨기 때문에 9자리의 정수 중 9의 위치를 찾고,
	 * 9의 위치를 상,하,좌,우 이동시킨다. 
	 */
	static void bfs(int start) {
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int now=q.poll();
			String now_str=String.valueOf(now); // 정수를 String으로 변환
			int nine_index=now_str.indexOf("9"); // 9의 인덱스를 찾는다
			
			int x=nine_index/3; // 9가 2차원 배열에서 몇 번째 행에 위치하는지 계산
			int y=nine_index%3; // 9가 2차원 배열에서 몇 번에 열에 위치하는지 계산
			
			// 상,하,좌,우 이동
			for(int i=0;i<4;i++) {
				int nx=x+dx[i]; 
				int ny=y+dy[i];
				int move=nx*3+ny; // 2차원 배열에서 이동한 인덱스를 1차원 배열의 인덱스로 변경
				
				// 배열의 범위를 벗어난 경우 넘어간다. 
				if(nx<0||ny<0||nx>=3||ny>=3)
					continue;
				
				// 이동할 수 있다면 이동할 인덱스에 있는 숫자와 9를 swap
				StringBuilder next_str=new StringBuilder(now_str);
				char temp=next_str.charAt(move);
				next_str.setCharAt(move,'9');
				next_str.setCharAt(nine_index, temp);
				
				int next_num=Integer.parseInt(next_str.toString());
				// 해당 경우가 이전에 나온적 없는 퍼즐 배치라면 이동횟수를 1 증가시킨 후 저장
				if(!map.containsKey(next_num)) {
					map.put(next_num,map.get(now)+1);
					q.offer(next_num);
				}
			}
		}
	}
}
