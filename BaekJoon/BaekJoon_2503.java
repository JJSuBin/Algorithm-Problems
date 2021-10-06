import java.util.*;

class Game_2503 {
	String num;
	int strike;
	int ball;
	
	public Game_2503(String num, int strike, int ball) {
		this.num=num;
		this.strike=strike;
		this.ball=ball;
	}
}
public class BaekJoon_2503 {
	static ArrayList<Game_2503> arr=new ArrayList<>();
	static boolean[] visited=new boolean[10];
	static int[] num=new int[3];
	static int n,result=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		// 민혁이가 물어본 숫자에 대한 영수의 대답을 연결리스트에 저장
		for(int i=0;i<n;i++) 
			arr.add(new Game_2503(sc.next(),sc.nextInt(),sc.nextInt()));
		
		dfs(0);
		System.out.println(result);
	}
	
	static void dfs(int depth) {
		// 3자리의 숫자가 만들어졌다면
		if(depth==3) {
			String n="";
			for(int i=0;i<3;i++)
				n+=num[i];
			
			// 만들어진 숫자가 연결리스트에 저장된 모든 경우와 일치하는지 체크
			for(int i=0;i<arr.size();i++) {
				int s=0,b=0;
				for(int j=0;j<3;j++) {
					// 숫자와 자릿수까지 일치하면 strike
					if(n.charAt(j)==arr.get(i).num.charAt(j))
						s++;
					// 자릿수는 일치하지 않지만 숫자를 포함한다면 ball
					else if(arr.get(i).num.contains(n.charAt(j)+""))
						b++;
				}
				
				// 연결리스트에 저장된 경우와 일치한다면 다음 경우의 수로 넘어간다.
				if(arr.get(i).strike==s&&arr.get(i).ball==b)
					continue;
					// 일치하지 않는다면 해당 수는 패스
					return;
			}
			// 연결리스트의 모든 경우의 수와 일치한다면 가능한 수로 판단하고 count
			result++;
			return;
		}
		
		// 백트래킹을 사용하여 중복되지 않는 3자리 숫자 만들기
		for(int i=1;i<=9;i++) {
			if(!visited[i]) {
				visited[i]=true;
				num[depth]=i;
				dfs(depth+1);
				visited[i]=false;
			}
		}
	}
}
