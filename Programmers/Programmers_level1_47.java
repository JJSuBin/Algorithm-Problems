import java.util.*;

public class level1_47 {
	public int solution(int[] nums) {
        int answer=1;
        int[] poketmon=nums.clone(); // nums 배열 복사
        
        Arrays.sort(poketmon); // 배열 정렬
        
        // 정렬된 배열에서 서로 다른 포켓몬의 개수를 count 한다.
        for(int i=0;i<poketmon.length-1;i++) {
        	if(poketmon[i]!=poketmon[i+1])
        		answer+=1;
        }
        
        /*
         * 서로 다른 포켓몬의 종류가 가져갈 수 있는 마리 수를 넘는다면
         * answer 값을 nums.length/2(가져갈 수 있는 최대 마릿수)로 갱신하고 return한다.
         * 그 외의 경우라면 서로 다른 포켓몬의 종류 수를 return 한다.
         */
        if(answer>nums.length/2)
        	return answer=nums.length/2;
        else 
        	return answer;
	}
}
