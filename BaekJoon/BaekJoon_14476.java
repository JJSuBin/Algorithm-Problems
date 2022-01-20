import java.io.*;
import java.util.*;

public class BaekJoon_14476 {
	static int n,max=0,maxIndex=0;
	static int[] gcd_LR, gcd_RL,num;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		num=new int[n];
		gcd_LR=new int[n];
		gcd_RL=new int[n];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			num[i]=Integer.parseInt(st.nextToken());
		
		// 초기값
		gcd_LR[0]=num[0];
		gcd_RL[n-1]=num[n-1];
		
		// 왼쪽부터 누적 gcd값 채워주기
		for(int i=1;i<n;i++)
			gcd_LR[i]=gcd(gcd_LR[i-1],num[i]);
		
		// 오른쪽부터 누적 gcd값 채워주기
		for(int i=n-2;i>=0;i--)
			gcd_RL[i]=gcd(gcd_RL[i+1],num[i]);
		
		
		// 하나씩 제외해가며 만들 수 있는 가장 큰 최대공약수 구하기
		for(int i=0;i<n;i++) {
			int gcd=0;
			if(i==0) 
				gcd=gcd_RL[1];
			
			else if(i==n-1)
				gcd=gcd_LR[n-2];
			
			else
				gcd=gcd(gcd_LR[i-1],gcd_RL[i+1]);
			
			if(num[i]%gcd!=0&&gcd>max) {
				max=gcd;
				maxIndex=i;
			}
		}
		
		if(max==0)
			System.out.println(-1);
		else
			System.out.println(max+" "+num[maxIndex]);
	}

	static int gcd(int a, int b) {
		if(b==0)
			return a;
		
		return gcd(b,a%b);
	}
}
