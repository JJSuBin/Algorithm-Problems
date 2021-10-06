import java.io.*;
import java.util.*;

class power_19637 {
	String state; // 상태
	int energy; // 전투력
	
	public power_19637(String state, int energy) {
		this.state=state;
		this.energy=energy;
	}
}

public class BaekJoon_19637 {
	static ArrayList<power_19637> arr=new ArrayList<>();
	static int n,m;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st=new StringTokenizer(br.readLine()," ");

		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		// 각 상태을 측정할 전투력을 입력받아 리스트에 저장
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			String s=st.nextToken();
			int e=Integer.parseInt(st.nextToken());
			
			arr.add(new power_19637(s,e));
		}
		
		// 전투력을 입력받아 어떤 상태인지 출력
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int e=Integer.parseInt(st.nextToken());
			
			sb.append(binarySearch(e)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	// 이진탐색
	static String binarySearch(int state) {
		int start=0;
		int end=arr.size()-1; 
		
		while(start<=end) {
			int mid=(start+end)/2;
			
			// 전투력이 mid 번째의 전투력보다 작다면 전투력이 낮은 범위에서 재탐색
			if(state<=arr.get(mid).energy)
				end=mid-1;
			
			// 전투력이 mid 번째의 전투력보다 크다면 전투력이 큰 범위에서 재탐색
			else 
				start=mid+1;
		}
		// 정답 return
		return arr.get(end+1).state;
	}
}
