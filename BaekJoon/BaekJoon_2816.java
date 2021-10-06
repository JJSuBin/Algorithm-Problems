import java.util.*;

public class BaekJoon_2816 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] channel=new String[n];
		
		for(int i=0;i<n;i++)
			channel[i]=sc.next();
		
		// KBS1을 첫 번째 채널로 만들기
		for(int i=0;i<n;i++) {
			// KBS1을 찾았다면 해당 i인덱스만큼 채널 끌어 올리기
			if(channel[i].equals("KBS1")) {
				String temp="";
				for(int j=i;j>0;j--) {
					System.out.print(4);
					temp=channel[j-1];
					channel[j-1]=channel[j];
					channel[j]=temp;
				}
				break;
			}
			// KBS1 찾기 전까지 화살표 내리기
			else
				System.out.print(1);
		}
		
		// KBS1을 첫 번째로 옮기고 난 후 두 번째 채널이 KBS2라면 종료
		if(channel[1].equals("KBS2"))
			System.exit(0);
		
		// KBS2을 두 번째 채널로 만들기
		for(int i=0;i<n;i++) {
			/*
			 * KBS2을 찾았다면 해당 i인덱스만큼 채널 끌어 올리기
			 * 이때 첫 번째 채널은 KBS1인것 주의
			 */
			if(channel[i].equals("KBS2")) {
				String temp="";
				for(int j=i;j>1;j--) {
					System.out.print(4);
					temp=channel[j-1];
					channel[j-1]=channel[j];
					channel[j]=temp;
				}
				break;
			}
			// KBS2 찾기 전까지 화살표 내리기
			else
				System.out.print(1);
		}
	}
}
