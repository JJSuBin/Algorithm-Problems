import java.util.*;

public class level1_32 {
	public int[] solution(int[] numbers) {
        // 중복 값을 허용하지 않는 hashSet 선언
		Set<Integer> hashSet=new HashSet<Integer>();
        
		// 서로 다은 인덱스에 있는 두 개의 수를 뽑아 더한 값을 hashSet에 저장
        for(int i=0;i<numbers.length;i++) 
        	for(int j=i+1;j<numbers.length;j++)
        		hashSet.add(numbers[i]+numbers[j]);
        
        /*
         * hashSet에서 값을 가져오기 위해서느 Iterator를 사용해야 한다.
         * hashSet.iterator()로 hashSet을 iterator에 담은 후
         * .next() 함수를 통해 값을 하나씩 뽑아내야 한다.
         */
        Iterator<Integer> iter=hashSet.iterator();
        int[] answer=new int[hashSet.size()];
        int count=0;
        while(iter.hasNext()) {
        	answer[count]=iter.next();
        	count++;
        }
        
        // 배열 값을 정렬하여 반환
        Arrays.sort(answer);
        return answer;
    }
}
