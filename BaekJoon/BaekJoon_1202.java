import java.io.*;
import java.util.*;

class Jewelry {
	int weight, value;
	
	public Jewelry(int weight, int value) {
		this.weight=weight;
		this.value=value;
	}
}

public class BaekJoon_1202 {
	/*
	 * 우선순위 큐를 이용해야 하는 문제 
	 * k개의 가방을 무게가 가벼운 순으로 처리해야 한다.
	 * 보석 또한 무게가 가벼운 순으로 정렬하여 k번째 가방에 들어갈 수 있는 모든 보석을 최대힙에 삽입한다.
	 * 최대힙의 root에는 가방에 들어갈 수 있는 가장 비싼 가격이 들어있기 때문에 root 노드만 poll
	 * 
	 * 가방을 가벼운 순으로 정렬했기 때문에 k번째 가방에 들어갈 수 있는 보석은 k+1번째 가방에도 들어갈 수 있다.
	 * 따라서 이미 최대힙에 들어가있는 보석들도 고려하여 k+1에 들어갈 가방을 구해줘도 된다.
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken()); // 보석의 개수
		int k=Integer.parseInt(st.nextToken()); // 가방의 개수
		
		Jewelry[] jewelry=new Jewelry[n];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			
			int w=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			jewelry[i]=new Jewelry(w,v);
		}
		
		// n개의 보석은 무게가 가벼운 순으로 정렬, 무게가 같다면 가격 순으로 정렬
		Arrays.sort(jewelry, new Comparator<Jewelry>() {
			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				// TODO Auto-generated method stub
				if(o1.weight==o2.weight)
					return o1.value-o2.value;
				
				return o1.weight-o2.weight;
			}
		});
		
		int[] bag=new int[k];
		for(int i=0;i<k;i++) 
			bag[i]=Integer.parseInt(br.readLine());
		
		Arrays.sort(bag); // 가방은 무게가 가벼운 순부터 처리
		
		// 현재 가방에 넣을 수 있는 가장 값어치 있는 보석이 들어있는 우선순위 큐(최대 힙)
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); 
		int index=0; // n개의 보석을 가르키는 포인터
		long total=0;
		
		for(int i=0;i<k;i++) {
			// n개의 보석 중 가방에 들어갈 수 있는 무게의 보석은 큐에 삽입
			while(index<n&&jewelry[index].weight<=bag[i]) {
				pq.add(jewelry[index].value);
				index++; // 포인터 증가
			}
			
			// 큐에 제일 위에있는 노드가 가방에 넣을 수 있는 가장 비싼 보석
			if(!pq.isEmpty())
				total+=pq.poll();
		}
		
		System.out.println(total);
	}

}
