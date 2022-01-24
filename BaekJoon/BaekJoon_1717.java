import java.io.*;
import java.util.*;

public class BaekJoon_1717 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st=new StringTokenizer(br.readLine());
	     
	     int n=Integer.parseInt(st.nextToken());
	     int m=Integer.parseInt(st.nextToken());
	     
	     parent=new int[n+1];
	     for(int i=1;i<=n;i++)
	    	 parent[i]=i;
	     
	     StringBuilder sb=new StringBuilder();
	     for(int i=0;i<m;i++) {
	    	 st=new StringTokenizer(br.readLine());
	    	 
	    	 int command=Integer.parseInt(st.nextToken());
	    	 int a=Integer.parseInt(st.nextToken());
	    	 int b=Integer.parseInt(st.nextToken());
	    	 
	    	 if(command==0)
	    		 union(a,b);
	    	 else if(command==1)
	    		 sb.append((isParentSame(a,b))?"YES":"NO").append('\n');
	    	 else 
	    		 continue;
	     }
	     System.out.println(sb);
	}
	
	// a,b의 부모 중 값이 더 작은 값으로(더 부모인 값) 변경하는 함수
	static void union(int a, int b) {
		a=find(a);
		b=find(b);
		
		if(a!=b) {
			if(a<b)
				parent[b]=a;
			else
				parent[a]=b;
		}
	}
	
	// a,b의 부모가 같은지 확인하는 함수
	static boolean isParentSame(int a, int b) {
		a=find(a);
		b=find(b);
		
		if(a==b)
			return true;
		else 
			return false;
	}
	
	// x의 부모를 찾는 함수
	static int find(int x) {
		if(x==parent[x])
			return x;
		
		return parent[x]=find(parent[x]);
	}

}
