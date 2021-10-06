import java.util.*;
public class greedy_p311 {
public static int n;
// 연결리스트 또는 배열 사용 가능
public static ArrayList<Integer> people=new ArrayList<Integer>();

public static void main(String[] args) {
// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
int group=0; // 최종적인 그룹의 수

for(int i=0;i<n;i++)
people.add(sc.nextInt());

int count=0; // 현재 그룹에 참여한 모험가의 수

Collections.sort(people);
/*
* 한 그룹에는 최소한의 모험가가 합류해야 가장 많은 그룹을 만들 수 있다.
* 그러기 위해서는 배열을 오름차순으로 정렬 후 공포도가 가장 낮은 모험가 부터 최소한의 인원으로 그룹을 만들어야 한다.
* 정렬 후 연결리스트 처음부터 그룹에 합류시키고 count를 증가시킨다.
* 모험가의 공포도 만큼 count가 증가하면 그룹의 수를 1 증가시키고 count를 초기화시켜준다.
*/
for(int i=0;i<n;i++) {
count+=1;
if(count>=people.get(i)) {
group+=1;
count=0;
}
}
System.out.println(group);
}
}
