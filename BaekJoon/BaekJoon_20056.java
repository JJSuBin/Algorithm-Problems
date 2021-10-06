import java.util.*;

class FireBall{
    int m, d, s;
    
    FireBall(int m, int d, int s) {
        this.m = m;
        this.d = d;
        this.s = s;
    }
}
public class BaekJoon_20056 {
	static int n;
	static LinkedList<FireBall> map[][];
	static int dx[] = {-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		       
		n =sc.nextInt();
		int M=sc.nextInt();
		int K=sc.nextInt();
		map = new LinkedList[n][n];
		
		// 각 배열의 좌표마다 연결리스트 생성
		for(int i=0;i<n;i++)
		    for(int j=0;j<n;j++)
		        map[i][j]=new LinkedList<>();
		        
		for(int i=0;i<M;i++) {
		    int r=sc.nextInt()-1;
		    int c=sc.nextInt()-1;
		    int m=sc.nextInt();
		    int s=sc.nextInt();
		    int d=sc.nextInt();
		    
		    // r행 c열에 질량 m, 방향 d, 속도 s 파이어볼 저장
		    map[r][c].add(new FireBall(m,d,s));
		}
		
		// k번 파이어볼 이동 수행
		for(int i=0;i<K;i++)
		     	move();
		
		// 모든 파이어볼의 질량의 합 구하기
		System.out.println(sum());
	}
		    
	public static void move() {
		// 이동한 파이어볼의 정보를 저장할 임시 배열 
		LinkedList<FireBall> next[][]=new LinkedList[n][n];
		// 배열 초기화 
		for(int i=0;i<n;i++)
		    for(int j=0;j<n;j++)
		        next[i][j] = new LinkedList<>();
		 
		// 파이어볼 이동
		for(int i=0;i<n;i++) {
		    for(int j=0;j<n;j++) {
		    	// 파이어볼이 1개 이상 있다면
		        if(map[i][j].size()>=1) {
		        	// i행 j열에 배열에 있는 모든 파이어볼 이동
		           for(FireBall fb : map[i][j]) {
		               int distance=fb.s%n; // 이동할 속력이 n보다 큰 경우 반복을 방지하기 위해 모듈러 값 사용
		               // 현재 방향에 속력을 곱해 다음 좌표 값 계산
		               int x=i+dx[fb.d]*distance; 
		               int y=j+dy[fb.d]*distance;
		               
		               // 범위를 벗어난 경우 인덱스 조정
		               if(x>=n) x-=n; // 행이 아랫쪽으로 넘어간 경우
		               else if(x<0) x+=n; // 행이 윗쪽으로 넘어간 경우
		               if(y>=n)  y-=n; // 열이 오른쪽으로 넘어간 경우
		               else if(y<0) y+=n; // 열이 왼쪽으로 넘어간 경우
		               
		               /*
		                * 임시 배열의 이동한 좌표 x행 y열에 새로운 파이어볼 저장 
		                * 해당 함수는 단순히 파이어볼을 이동시키는 것이기 때문에 기존의 질량,방향,속도를 가져간다.
		                */
		               next[x][y].add(new FireBall(fb.m, fb.d, fb.s));
		           	}
		        }
		    }
		}	
		map = next; // 배열 덮어씌우기
		split(); // 파이어볼 합치기
	}
		    
	public static void split() {
		for(int i=0;i<n;i++) {
		    for(int j=0;j<n;j++) {
		    	// 배열을 탐색하면서 파이어볼이 두개 이상인 곳을 찾는다.
		        if(map[i][j].size()>=2) {
		           int mSum=0; // 질량 합 
		           int sSum=0; // 속도 합
		           boolean even=true,odd=true; 
		           
		           // 모든 파이어볼 탐색
		           for(FireBall fb:map[i][j]) {
		              mSum+=fb.m; // 질량 합 누적
		              sSum+=fb.s; // 속도 합 누적
		              
		              /*
		               * 파이어볼의 위치가 모두 짝수라면 even 값이 true, 모두 홀수라면 odd 값이 true일 것이고,
		               * 짝수와 홀수가 섞여있다면 even, odd 값이 모두 false일 것이다. 
		               * 
		               * 이후 나누어진 파이어볼을 배치할 때 even 또는 odd 중 하나라도 true 값이 있다면 0,2,4,6에 배치하고
		               * 두 값중 true가 하나도 없다면 1,3,5,7에 배치하면 된다. 
		               */
		              if(fb.d%2==0) 
		                 odd=false;
		              else 			
		                 even=false;
		          }
		           
		           // 나누어질 파이어볼의 질량, 속도를 구한다.
		           int m=mSum/5; // 질량은 (합쳐진 파이어볼 질량의 합)/5
		           int s=sSum/map[i][j].size(); // 속력은 (합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)
		                   
		           map[i][j].clear(); // 해당 좌표의 파이어볼은 각 방향으로 나뉘기 때문에 배열 비우기
		           
		           // 질량이 0이면 소멸되기 때문에 질량이 0이 아니라면 파이어볼 배치
		           if(m>0) {		                        
		        	   for(int a=0;a<4;a++) {		                            
		        		   // 합쳐지는 파이어볼의 방향이 모두 홀수이거나 짝수이면 0,2,4,6에 파이어볼 배치
		        		   if(odd||even)		                                
		        			   map[i][j].add(new FireBall(m,0+2*a,s));		                            
		        		   // 합쳐지는 파이어볼의 방향이 모두 홀수이거나 짝수가 아니면 1,3,5,7에 파이어볼 배치
		        		   else		                                
		        			   map[i][j].add(new FireBall(m,1+2*a,s));
		                        
		        	   }		                    
		           }		           		                
		        }		            
		    }		        
		}		    
	}
		    
	// 모든 파이어볼의 질량 합 구하기
	public static long sum() {
		 long sum=0;
		 for(int i=0;i<n;i++) {
		     for(int j=0;j<n;j++){
		         for(FireBall fb:map[i][j])
		             sum+=fb.m;
		     }
		}		        
		return sum;
	}
}

