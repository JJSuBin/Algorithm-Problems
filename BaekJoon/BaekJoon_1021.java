import java.util.*;

public class BaekJoon_1021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        LinkedList<Integer> deque = new LinkedList<Integer>();
 
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        for (int i=1;i<=n;i++) 
        	deque.offer(i);
        
        int count=0; // 이동 횟수 저장 변수
       
        for (int i=0;i<m;i++) {
            int num = sc.nextInt(); // 뽑아내려는 수 입력 받기
            while (num!=deque.get(0)) { // 덱에 뽑아내려는 수가 처음 위치에 오기 전까지 이동 진행
                /*
                 * 덱의 중앙으로 부터 뽑아내려는 수의 인덱스 번호가 앞에 있는 경우
                 * 앞에 있는 원소들을 모두 뒤로 보낸다.(2번 연산)
                 */
            	if (deque.indexOf(num) <= deque.size() / 2) {
                    int first = deque.getFirst();
                    deque.removeFirst();
                    deque.addLast(first);
                } 
            	/*
                 * 덱의 중앙으로 부터 뽑아내려는 수의 인덱스 번호가 뒤에 있는 경우
                 * 뒤에 있는 원소들을 모두 앞으로 보낸다.(3번 연산)
                 */
                else {
                    int last = deque.getLast();
                    deque.removeLast();
                    deque.addFirst(last);
                }
            	// 2번 or 3번 연산을 할때 마다 count 증가
                count++;
            }
            // 맨 앞에 뽑아내려는 원소가 위치한다면 해당 수 제거
            deque.removeFirst();
        }
        System.out.println(count);
	}
}
