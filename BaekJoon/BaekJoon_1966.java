import java.util.*;

public class BaekJoon_1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			LinkedList<int[]> q=new LinkedList<>();
			
			int n=sc.nextInt();
			int m=sc.nextInt();
			
			// {인덱스, 중요도} 형태로 연결리스트에 저장
			for(int i=0;i<n;i++)
				q.offer(new int[] {i, sc.nextInt()});
			
			int count=0;
			
			while(!q.isEmpty()) {
				int[] front=q.poll(); // 가장 첫 원소 저장
				/*
				 * 큐에서 poll된 원소가 가장 큰 경우는 
				 * 해당 원소의 위치가 m과 같은지 비교해야 하기 때문에
				 * front 원소가 가장 큰 원소인지 판변하는 변수가 필요하다. 
				 */
				boolean isMax=true; 
				
				// 첫 원소를 제외한 나머지 원소들과 front 비교
				for(int i=0;i<q.size();i++) {
					// 처음 뽑은 원소의 중요도보다 i번째 원소의 중요도가 클 경우
					if(front[1]<q.get(i)[1]) {
						// 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
						q.offer(front);
						for(int j=0;j<i;j++)
							q.offer(q.poll());
						
						// front원소가 가장 큰 원소가 아니였으므로 isMax 값을 false로 변경하고 탐색을 마침
						isMax=false;
						break;
					}
				}
				// front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
				if(isMax==false)
					continue;
				
				// front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서
				count++;
				// 찾고자 하는 문서라면 해당 테스트케이스 종료
				if(front[0]==m)
					break;
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
}
