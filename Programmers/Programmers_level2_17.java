import java.util.*;

public class level2_17 {
	public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++) {
        	/*
        	 * 기능 개발의 남은 시간 = (100 - 개발 완료한 퍼센티지) / 작업 속도로 구할 수 있다
        	 * 이때 나눗셈의 나머지가 생길 경우 하루를 더 투자하여 완료해야 하기 때문에 +1을 해주어야 한다.
        	 */
        	int day=((100-progresses[i])%speeds[i])>0?((100-progresses[i])/speeds[i])+1
					:((100-progresses[i])/speeds[i]);
			
        	q.add(day);
        }
        	
        
        ArrayList<Integer> arr=new ArrayList<Integer>();
       
        while(!q.isEmpty()) {
        	int time=q.poll(); // 제일 첫 번째 완료해야하는 작업
        	int count=1;
        	
        	/*
        	 * 큐가 비어있지 않고, 큐의 제일 처음에 있는 남은 시간이
        	 * 우선 완료되야 하는 작업의 시간보다 작은 경우 같이 배포되기 때문에 count 증가하고,
        	 * 해당 작업은 큐에서 삭제해준다.
        	 */
        	while(!q.isEmpty()&&time>=q.peek()) {
        		count++;
        		q.poll();
        	}
        	arr.add(count);
        }
        
		int[] answer=new int[arr.size()];
		for(int i=0;i<arr.size();i++)
			answer[i]=arr.get(i);
        
        return answer;
    } 
}
