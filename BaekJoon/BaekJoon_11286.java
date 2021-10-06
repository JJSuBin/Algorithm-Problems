import java.io.*;
import java.util.*;

public class BaekJoon_11286 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        /*
         * 절댓값이 같다면 두 수를 비교하여 오름차순으로 정렬하고
         * 절댓값이 다른 경우는 절댓값이 작은 순서로 오름차순 정렬한다.
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->
        Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
        );
        
        for(int i=0;i<n;i++) {
        	int val=Integer.parseInt(br.readLine());
        	
        	if(val==0) {
        		if(pq.isEmpty())
        			System.out.println(0);
        		else 
        			System.out.println(pq.poll());
        	}
        	else
        		pq.offer(val);
        }
	}
}
