import java.util.*;

class team implements Comparable<team>{
	int teamnumber;
	int gold;
	int silver;
	int bronze;
	int rank;
	
	public team(int teamnumber, int gold, int silver, int bronze) {
		this.teamnumber=teamnumber;
		this.gold=gold;
		this.silver=silver;
		this.bronze=bronze;
	}
	
	@Override
	public int compareTo(team o) {
	    // 금매달의 개수가 같은 경우
		if(this.gold==o.gold) {
			// 은매달의 개수가 같은 경우
	         if(this.silver==o.silver) {
	        	 // 동매달의 개수로 순위 결정
	             return o.bronze-this.bronze;
	         }
	         // 은매달의 개수로 순위 결정
	         else {
	             return o.silver-this.silver;
	         }
	     }
		// 금매달의 개수로 순위 결정
	     else {
	         return o.gold-this.gold;
	     }
	 }
}

public class BaekJoon_8979 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		PriorityQueue<team> pq=new PriorityQueue<team>();
		
		for(int i=0;i<n;i++) {
			int num=sc.nextInt(); // 팀 번호
			int g=sc.nextInt(); // 금매달 개수
			int s=sc.nextInt(); // 은매달 개수
			int b=sc.nextInt(); // 동매달 개수
			
			pq.offer(new team(num,g,s,b));
		}
		
		// 1등인 나라를 큐에서 꺼낸다.
		team prev=pq.poll(); 
		prev.rank=1; 
		// 1등인 나라가 알고자하는 k 국가와 같은 경우
		if(prev.teamnumber==k) {
			System.out.println(prev.rank);
			return;
		}
		
		int rankcount=2; // 순위 count 변수
		while(!pq.isEmpty()) {
			team current=pq.poll();
			
			// 앞선 나라와 모든 매달의 개수가 같은 경우 
			if(prev.gold==current.gold
					&&prev.silver==current.silver
					&&prev.bronze==current.bronze) 
				// 같은 순위 유지
				current.rank=prev.rank;
			// 매달의 개수가 다르다면 +1등한 수 저장(2부터 시작했기 때문)
			else
				current.rank=rankcount;
			
			// 현재 팀의 번호가 알고자하는 k 국가라면 해당 국가의 랭킹 출력후 return
			if(current.teamnumber==k) {
				System.out.println(current.rank);
				return;
			}
			
			// 값 갱신
			rankcount++;
			prev=current;
		}
		
	}

}
