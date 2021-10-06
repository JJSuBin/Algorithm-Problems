import java.util.*;

public class level2_5 {
	public int solution(int []A, int []B) {
        int answer = 0;
        // 각각의 배열에 A, B 배열 복사
        int[] arr1=A.clone();
        int[] arr2=B.clone();
        
        // 두 배열 모두 정렬
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        /*
         * 두 배열의 누적 합이 최소가 되기 위해서는
         * A 배열의 최댓값을 B 배열의 최솟값과 곱해주어야 한다.
         * 
         * 따라서 A 배열은 오름차순대로 곱해주고 
         * B 배열은 내림차순대로 곱해준다.
         */
        for(int i=0;i<arr1.length;i++) {
        	answer+=arr1[i]*arr2[arr2.length-1-i];
        }
        return answer;
    }
}
