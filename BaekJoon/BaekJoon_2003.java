import java.io.*;
import java.util.*;

public class BaekJoon_2003 {
	static int[] arr;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.valueOf(st.nextToken());
		m=Integer.valueOf(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		arr=new int[n];
		
		// 입력값 받기 
		for(int i=0;i<n;i++) {
			arr[i]=Integer.valueOf(st.nextToken());
		}
		
		System.out.println(twoPointer());
	}
	
	static int twoPointer() {
		int count=0;
		int startPoint=0,endPoint=0;
		int sum=0;
		
		while(true) {
			/*
			 * m보다 sum이 크면 값을 줄여서 m을 맞춰야 하므로 
			 * 현재 startpoint 값을 빼고 한칸 앞으로 이동한다. 
			 */
			if(sum>=m) 
				sum-=arr[startPoint++];
			
			// 범위를 초과할 경우 종료
			else if(endPoint>=arr.length) 
				break;
			
			/*
			 * m보다 sum이 작으면 값을 늘려서 m을 맞춰야 하므로 
			 * 현재 endpoint를 한칸 앞으로 이동시키고 그 인덱스의 원소 값을 더해준다.
			 */
			else 
				sum+=arr[endPoint++];
			
			if(sum==m) 
				count++;
		}
		
		return count;
	}
}
