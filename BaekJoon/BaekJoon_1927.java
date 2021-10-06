import java.io.*;
import java.util.*;

public class BaekJoon_1927 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        // 최소 힙으로 구현된 우선순위 큐 선언
        PriorityQueue<Integer> qp=new PriorityQueue<Integer>();
        for(int i=0;i<n;i++) {
        	int val=Integer.parseInt(br.readLine());
        	// 입력 받은 값이 0이면 삭제 연산을 수행한다.
        	if(val==0) {
        		if(qp.isEmpty()) 
        			System.out.println(0); // 큐가 비어있는 경우 0 반환
        		else
        			System.out.println(qp.poll());
        	}
        	// 자연수를 입력 받은 경우 우선순위 큐에 삽입
        	else 
        		qp.offer(val);
        }
	}
}
