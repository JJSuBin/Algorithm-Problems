import java.util.*;

public class level1_36 {
	public int solution(int[] d, int budget) {
        int answer=0;
        int[] money=d.clone(); // 배열 d를 복제한 배열
        int total=0;
        
        /*
         * 최대한 많은 부서의 물품을 구매하기 위해서는
         * 예산이 작은 부서부터 물품을 구매해야 한다.
         * 따라서 예산을 오름차순으로 정렬한다. = 그리디 알고리즘
         */
        Arrays.sort(money);
        
        for(int i=0;i<money.length;i++) {
        	total+=money[i];
        	// 예산이 초과하면 해당 부서는 count 하지 않고 for문 종료
        	if(total>budget)
        		break;
        	answer++;       	
        }
        return answer;
    }
}
