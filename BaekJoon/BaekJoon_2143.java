import java.io.*;
import java.util.*;

public class BaekJoon_2143 {
	static int t,n,m;
	static int[] a,b;
	static ArrayList<Integer> sub_A=new ArrayList<>();
	static ArrayList<Integer> sub_B=new ArrayList<>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t=Integer.parseInt(br.readLine());
		
		n=Integer.parseInt(br.readLine());
		a=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(st.nextToken());
		
		m=Integer.parseInt(br.readLine());
		b=new int[m];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++)
			b[i]=Integer.parseInt(st.nextToken());
		//--------------------------------------------input
		
		make_sub();
		
		System.out.println(TwoPointer());
	}
	
	// a,b 배열의 부분합을 구해 저장 후 정렬
	static void make_sub() {
		for(int i=0;i<n;i++) {
			int sum=0;
			for(int j=i;j<n;j++) {
				sum+=a[j];
				sub_A.add(sum);
			}
		}
		
		for(int i=0;i<m;i++) {
			int sum=0;
			for(int j=i;j<m;j++) {
				sum+=b[j];
				sub_B.add(sum);
			}
		}
		
		
		Collections.sort(sub_A);
		Collections.sort(sub_B);
	}
	
	static long TwoPointer() {
		int pa=0; // 서브 a의 리스트를 가리키는 포인터(처음부터)
		int pb=sub_B.size()-1; // 서브 b의 리스트를 가리키는 포인터(끝부터)
		long result=0;
		
		while(pa<sub_A.size()&&pb>=0) {
			long sum=sub_A.get(pa)+sub_B.get(pb); // 합
			
			// 합이 t와 같다면 각 서브 리스트의 포인터가 가리키는 숫자와 같은 숫자가 리스트에 있는지 검사
			if(sum==t) {
				int num_a=sub_A.get(pa); // 현재 서브 a의 포인터가 가리키는 숫자
				int num_b=sub_B.get(pb); // 현재 서비 b의 포인터가 가리키는 숫자 숫자
				long count_a=0;
				long count_b=0;
				
				while(pa<sub_A.size()&&sub_A.get(pa)==num_a) {
					pa++; // 같은 숫자의 개수만큼 포인터 증가
					count_a++; // 같은 숫자의 개수 count
				}
				
				while(pb>=0&&sub_B.get(pb)==num_b) {
					pb--; // 같은 숫자의 개수만큼 포인터 감소
					count_b++; // 같은 숫자의 개수 count
				}
				
				// 중복된 숫자로 만들 수 있는 경우의 수 더해주기
				result+=(count_a*count_b);
			}
			
			// 합이 t보다 작다면 서브 a의 포인터 증가(=누적 합 증가)
			else if(sum<t)
				pa++;
			// 합이 t보다 크다면 서브 b의 포인터 감소(=누적 합 감소)	
			else if(sum>t)
				pb--;
		}
		
		return result;
	}
}
