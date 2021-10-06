import java.util.*;

public class BaekJoon_3036 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int[] arr=new int[n]; // 원 반지름 저장 배열
		int[] arr2=new int[n]; // 최대공약수 저장 배열
		
		// 링 반지름 입력 받기
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		// 첫 번째 원과의 최대 공약수 구해서 배열에 저장
		for(int i=1;i<n;i++)
			arr2[i]=gdc(arr[0],arr[i]);
		
		// 분모와 분자를 최대공약수로 나눠주고 출력
		for(int i=1;i<n;i++)
			System.out.println(arr[0]/arr2[i]+"/"+arr[i]/arr2[i]);
		
	}
	
	// 최대공약수 구하는 함수
	public static int gdc(int a, int b) {
		while(b!=0) {
			int r=a%b;
			
			a=b;
			b=r;
		}
		return a;
	}
}
