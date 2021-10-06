import java.util.*;
class Food implements Comparable<Food> {
private int time;
private int index;

public Food(int time, int index) {
this.time = time;
this.index = index;
}
public int getTime() {
return this.time;
}
public int getIndex() {
return this.index;
}

// 시간이 짧은 것이 높은 우선순위를 가지도록 설정
@Override
public int compareTo(Food other) {
return Integer.compare(this.time, other.time);
}
}
/*
* 시간이 가장 적게 걸리는 음식을 다 먹는다면 그보다 오래 걸리는 음식도 그만큼 먹게 된다는 점을 이용하여
* 우선순위 큐에 시간이 적게 걸리는 음식부터 삽입한다(=음식량이 적은 순서 부터)
*/
public class greedy_p316 {
public int solution(int[] food_times, long k) {
long summary=0;
// 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1 반환(문제 조건)
for(int i=0;i<food_times.length;i++) {
summary+=food_times[i];
}
if(summary<=k) return -1;

// 시간이 작은 음식부터 빼야 하므로 우선순위 큐 이용
PriorityQueue<Food> pq=new PriorityQueue<>();
for(int i=0;i<food_times.length;i++) {
// (음식 시간, 음식번호) 형태로 우선순위 큐에 삽입 -> 음식번호는 1번부터 저장하기 위해 +1
pq.offer(new Food(food_times[i],i+1));
}

summary=0; // 먹기위해 사용한 시간
long previous=0; // 직전에 다 먹은 음식 시간
long length=food_times.length; // 남은 음식의 개수

/*
* 기본적으로 n번째 음식을 먹기까지는 n번째 음식을 먹는데 걸리는 시간 * 현재 음식의 개수 만큼의 시간이 소요된다.
* 예를 들어 총 3개의 음식 중 먹는데 4초가 걸리는 음식이있다면 그 음식을 모두 먹는데는 12초가 소요된다.
*
* summary + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
* summary에는 가장 시간이 적게 걸리는 음식부터 해당 음식을 모두 먹기까지 걸리는 시간을 저장한 변수이다(계속 증가하는 변수)
* (현재의 음식 시간 - 이전 음식 시간)을 하는 이유는 현재 음식 시간에서 이전 음식 시간만큼을 빼야
* 이전 음식을 먹은 만큼의 양이 줄어들기 때문이며 이렇게 최종적으로 음식을 먹을 시간이 계산됐으면 * 현재 음식 개수
* 해야 해당 음식을 모두 먹기까지의 시간이 도출된다.
* summary+((pq.peek().getTime()-previous)*length 값이 k보다 작지 않다면 큐 제일 처음에 있는(현재 시간이 제일 작은 음식)
* 음식을 모두 먹지 못한다는 의미이기 떄문에(이러한 이유로 pq.poll()이 아닌 peek()함수 사용) -> 큐에서 삭제하기 전 가능한지 여부 먼저 검사
* 남은 음식을 일렬로 나열한 후 (k - summary) % length) 번쨰의 음식이 k초 후 먹을 음식 번호가 된다.
*/
while(summary+((pq.peek().getTime()-previous)*length)<=k) {
int now = pq.poll().getTime();
summary += (now - previous) * length;
length -= 1; // 다 먹은 음식 제외
previous = now; // 이전 음식 시간 재설정
}

// 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
ArrayList<Food> result = new ArrayList<>();
while (!pq.isEmpty()) {
result.add(pq.poll());
}
// 음식의 번호 기준으로 정렬
Collections.sort(result, new Comparator<Food>() {
@Override
public int compare(Food a, Food b) {
return Integer.compare(a.getIndex(), b.getIndex());
}
});

// 이후 먹을 음식의 번호 계산
return result.get((int) ((k - summary) % length)).getIndex();
}
}
