import java.io.*;
import java.util.*;

public class BaekJoon_10815 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int arr[];
    
	public static void main(String[] args) throws Exception {
		n=Integer.parseInt(br.readLine());
        arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());

        // 숫자 카드 오름차순 정렬
        Arrays.sort(arr);

        m=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<m;i++) {
            int num=Integer.parseInt(st.nextToken());
            // 이분 탐색을 해서 해당 숫자가 있는 경우
            if(binarySearch(num)) 
            	bw.write("1 ");
            // 이분 탐색을 해서 해당 숫자가 없는 경우
            else 
            	bw.write("0 ");
        }
        bw.close();
        br.close();
	}
	
	// 이분탐색
	public static boolean binarySearch(int target) {
		int start=0;
		int end=n-1;
		
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(arr[mid]==target)
				return true;
			
			else if(arr[mid]>target)
				end=mid-1;
			
			else 
				start=mid+1;
		}
		return false;
	}
}
