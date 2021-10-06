import java.io.*;
import java.util.*;

public class BaekJoon_11279 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        /*
         * 대표적으로 우선순위 큐가 힙을 사용하여 구현하는 자료구조이다.
         * 기본적으로 자바에서 제공하는 우선순위 큐를 선언하면 최소 힙을 사용한 우선순위 큐가 만들어지기 때문에
         * Collections.reverseOrder()를 사용하여 최대 힙으로 바꾸어준다.
         */
        PriorityQueue<Integer> qp=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++) {
        	int val=Integer.parseInt(br.readLine());
        	// 입력 받은 값이 0이면 삭제 연산을 수행한다.
        	if(val==0) {
        		if(qp.isEmpty()) // 큐가 비어있는 경우 0 반환
        			System.out.println(0);
        		else
        			System.out.println(qp.poll());
        	}
        	// 자연수를 입력 받은 경우 우선순위 큐에 삽입
        	else 
        		qp.offer(val);
        }
	}
}
