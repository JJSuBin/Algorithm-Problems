import java.io.*;
import java.util.*;

public class BaekJoon_20053 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(br.readLine());
		
		while(testcase-->0) {
			int n=Integer.parseInt(br.readLine());
			int max=Integer.MIN_VALUE;
			int min=Integer.MAX_VALUE;
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				int num=Integer.parseInt(st.nextToken());
				
				max=Math.max(max, num); // 최댓값 찾기
				min=Math.min(min, num); // 최솟값 찾기
			}
			
			System.out.println(min+" "+max);
		}
	}

}
