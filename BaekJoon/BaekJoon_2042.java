import java.io.*;
import java.util.*;

public class BaekJoon_2042 {
	static int n,m,k,s;
	static long[] nums;
	static long[] tree;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		nums=new long[n];
		
		for(int i=0;i<n;i++)
			nums[i]=Long.parseLong(br.readLine());
		
		s=1;
		/*
		 * 포화 이진트리의 노드는 2의 거듭제곱만큼 늘어나므로 
		 * 말단노드가 n개를 포함할 수 있을 때까지 노드 수를 2씩 늘려나가면서 깊이를 구한다.
		 */
		while(s<=n)
			s*=2;
		
		tree=new long[2*s+1];
		
		init_Bottom();
		
		for(int i=0;i<m+k;i++) {
			st=new StringTokenizer(br.readLine());
			long a=Long.parseLong(st.nextToken());
			long b=Long.parseLong(st.nextToken());
			long c=Long.parseLong(st.nextToken());
			
			if(a==1) {
				long diff=c-tree[(int) (b+s-1)];
				update(1,s,1,b,diff);
			}
			else if(a==2) {
				System.out.println(query(1,s,1,b,(int)c));
			}
			else 
				return;
		}
		
	}
	
	static void init_Bottom() {
		// Leaf에 값 반영
		for(int i=0;i<n;i++)
			tree[s+i]=nums[i];
		
		/*
		 * 내부노드 채우기
		 * 내부노드의 가장 마지막 인덱스는 말단 노드의 인덱스 시작인 s에 -1한 값이다.(루트는 인덱스 1, 0은 사용하지 X)
		 */
		for(int i=s-1;i>0;i--)
			tree[i]=tree[i*2]+tree[i*2+1]; // 왼쪽 자식 + 오른쪽 자식
	}
	
	static long query(long left, long right, long node, long queryleft, long queryright) {
		// 연관이 없음 -> 결과에 영향이 없는 값(0) return
		if(queryleft>right||left>queryright)
			return 0;
		
		// 판단 가능 -> 현재 노드 값 return
		else if(queryleft<=left&&right<=queryright)
			return tree[(int) node];
		
		// 판단 불가 -> 자식에게 위힘, 올라온 값을 return 
		else {
			int mid=(int) ((left+right)/2);
			long leftResult=query(left,mid,node*2,queryleft,queryright);
			long rightResult=query(mid+1,right,node*2+1,queryleft,queryright);
			return leftResult+rightResult;
		}
	}
	
	static void update(long left, long right, long node, long target, long diff) {
		// 연관 없음
		if(target<left||right<target)
			return;
		
		// 연관 있음 -> 현재 노드에 diff 반영 -> 자식에게 diff 전달
		else {
			tree[(int) node]+=diff;
			if(left!=right) {
				int mid=(int) ((left+right)/2);
				update(left,mid,node*2,target,diff);
				update(mid+1,right,node*2+1,target,diff);
			}
		}
	}
}
