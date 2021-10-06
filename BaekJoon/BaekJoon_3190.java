import java.util.*;
class Node_p327 {
private int time;
private char direction;

public Node_p327(int time, char direction) {
this.time=time;
this.direction=direction;
}

public int getTime() {
return this.time;
}

public char getDirection() {
return this.direction;
}

}
class Position {
private int x;
private int y;

public Position(int x, int y) {
this.x = x;
this.y = y;
}

public int getX() {
return this.x;
}

public int getY() {
return this.y;
}
}

public class realization_p327 {
public static int[][] map=new int[101][101]; // 맵
public static ArrayList<Node_p327> info = new ArrayList<>(); // 방향 회전
public static int[] dx= {0,1,0,-1}; // 동,남,서,북
public static int[] dy= {1,0,-1,0};
public static int n,k,l;

/*
* 뱀 회전 함수
* 뱀은 처음에 동쪽을 보고있기 때문에 이동 배열에는 동,남,서,북 순서대로 저장되어 있다.
* 뱀이 왼쪽으로 회전하면 동->북->서->남 순서이기 때문에 dx[direction],dy[direction] 배열의 역으로 가기 위해서는
* direction-1을 해줘야 하며, 인덱스가 음수가 될 수 있기 때문에 예외처리가 필수적이다.
* 또한 오른쪽 회전인 경우에는 나머지 몫을 사용하여 인덱스 초과 예외 처리가 가능하다.
*/
public static int turn(int direction, char c) {
if(c=='L') direction=(direction==0)?3:direction-1;
else direction=(direction+1)%4;
return direction;
}

public static int simulate() {
int x=1, y=1; // 뱀의 처음 머리 위치
map[x][y]=2; // 뱀이 위치한 맵의 값은 2로 지정한다.
int direction=0; // 맨 처음 뱀의 머리는 동쪽을 향하고 있기 떄문에 dx, dy의 첫번째 값을 더해줘야 한다. 따라서 처음 direction 값은 0으로 지정
int time=0; // 누적 시간
int index=0; // info에 입력된 방향 전환의 정보 개수

/*
* 뱀이 차기하고 있는 위치 정보를 저장하는 큐
* 뱀이 이동할 떄 마다 (x좌표, y좌표) 형식으로 큐에 삽입한다.
* 이때 맨 처음 뱀의 위치부터 시작하여 뱀이 이동한 위치를 삽입하게 되면 뱀의 꼬리가 큐의 맨 처음에 오게된다.
* 이후에 사과를 만나지 않은 뱀의 꼬리를 삭제해야 하는 경우에는 q.poll() 사용하여 큐의 맨 처음 요소를
* 삭제하면 맨 나중의 꼬리부터 삭제할 수 있다.
*/
Queue<Position> q=new LinkedList<>();
q.offer(new Position(x,y));

while(true) {
int nx=x+dx[direction];
int ny=y+dy[direction];

// 뱀이 이동할 곳이 맵 안이며, 뱀의 몸통이 있는 위치가 아니라면
if(nx<=n&&nx>=1&&ny<=n&&ny>=1&&map[nx][ny]!=2) {
// 이동한 위치에 사과가 없는 경우
if(map[nx][ny]==0) {
map[nx][ny]=2; // 이동한 곳이 뱀이란 표시
q.offer(new Position(nx,ny)); // 새로운 뱀의 위치 큐에 삽입(머리)
Position prev=q.poll(); // 사과를 먹지 못했기 때문에 큐에 저장된 뱀의 꼬리 값 삭제, 큐의 다음 값이 뱀의 꼬리가 된다.
map[prev.getX()][prev.getY()]=0; // 기존의 뱀의 위치 초기화(2 삭제)
}
// 이동한 위치에 사과가 있는 경우에는 꼬리를 삭제하지 않고 새로운 뱀의 머리를 큐에 삽입한다.
if(map[nx][ny]==1) {
map[nx][ny]=2;
q.offer(new Position(nx,ny));
}
}
// 이동한 위치가 뱀의 몸통이거나 맵의 범위를 넘어간 경우에는 시간을 1 증가하고 종료한다.
else {
time+=1;
break;
}
// 다음 위치로 머리를 이동시킨다.
x=nx;
y=ny;
time+=1;

/* 뱀이 이동한 시간이 입력 받은 방향을 회전해야 하는 시간과 같아지면
* (= 입력받은 info 정보 한 개의 시간만큼 이동했다면)
* 입력받은 방향으로 머리를 이동시킨다.
*/
if(index<l&&time==info.get(index).getTime()) {
direction = turn(direction, info.get(index).getDirection());
index += 1;
}
}
return time;
}
public static void main(String[] args) {
// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
k=sc.nextInt();

// 사과가 위치한 곳은 1로 표시
for(int i=0;i<k;i++) {
int a=sc.nextInt();
int b=sc.nextInt();

map[a][b]=1;
}

// 방향 회전 정보 입력
l=sc.nextInt();
for(int i=0;i<l;i++) {
int x=sc.nextInt();
char c=sc.next().charAt(0);
info.add(new Node_p327(x,c));
}
System.out.println(simulate());
}
}
