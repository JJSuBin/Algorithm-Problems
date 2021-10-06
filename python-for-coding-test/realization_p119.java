import java.util.Scanner;
public class realization_p119 {
static int n,m,x,y,direction;
static int[][] map=new int[50][50];
static int[][] visit=new int[50][50];

//북,동,남,서 순으로 좌표 변경 값 저장
static int[] drow= {-1,0,1,0};
static int[] dcol= {0,1,0,-1};

//왼쪽으로 회전하면 방향을 바꿔주는 함수
public static void turn_left() {
direction-=1;
if(direction==-1) direction=3;
}
public static void main(String[] args) {
// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
m=sc.nextInt();

x=sc.nextInt();
y=sc.nextInt();
direction=sc.nextInt();
visit[x][y]=1;

for(int i=0;i<n;i++) {
for(int j=0;j<m;j++) {
map[i][j]=sc.nextInt();
}
}

int count=1; // 처음 위치를 포함하기 때문에 1로 초기화
int turn_time=0;

//움직임 시작
while(true) {
// 왼쪽으로 회전 후 해당 방향으로 이동
turn_left();
int nx=x+drow[direction];
int ny=y+dcol[direction];

//이동할 좌표가 육지이고 방문하지 않았다면 이동 후 count 증가, 회전 횟수 초기화
if(map[nx][ny]==0&&visit[nx][ny]==0) {
visit[nx][ny]=1;
x=nx;
y=ny;
count+=1;
turn_time=0;
}
//아니라면 회전 횟수 늘려주고 위로 이동 다시 왼쪽 회전 or 회전 횟수가 4가 되면 아래 if문 실행
else turn_time+=1;

//회전 횟수가 4가 됐다는 것은 네 방향 모두 가본 칸이거나 바다로 되어있는 경우
if(turn_time==4) {
// 바라보고 있는 방향으로 후진
nx=x-drow[direction];
ny=y-dcol[direction];

//뒤로 이동할 죄표가 육지인 경우 이동
if(map[nx][ny]==0) {
x=nx;
y=ny;
}
//아니면 종료
else break;
turn_time=0;
}
}
System.out.println(count);
}
}
