import java.util.*;
public class greedy_p314 {
public static int n;
public static ArrayList<Integer> coin=new ArrayList<Integer>();
public static void main(String[] args) {
// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
n=sc.nextInt();

for(int i=0;i<n;i++)
coin.add(sc.nextInt());

Collections.sort(coin);
/*
* 만약 target 보다 다음 동전의 단위가 크다면 만들 수 없는 금액이다.
* 예를들어 1,2,6,8원이 있다면 target은 1->2(1+1)->4(2+2)로 증가한다
* 이때 다음 동전이 6원이 target의 값인 4보다 크기 때문에 4원은 만들 수 없는 가장 작은 단위가 된다.
* 이때 target의 값 미만으로는 모든 단위를 만들 수 있다.
* 예를 들어 target의 값이 5가 나오면 4까지의 모든 금액은 만들 수 있다는 말과 같다.
*/
int target=1;
for(int i=0;i<n;i++) {
if(target<coin.get(i)) break;
target+=coin.get(i);
}
System.out.println(target);
}
}
