import java.util.*;

public class level1_27 {
	public int[] solution(int[] arr, int divisor) {
        int[] answer={};
        ArrayList<Integer> list=new ArrayList<>();
        
        // 배열의 값이 divisor로 나눠 떨어진다면 리스트에 저장
        for(int i=0;i<arr.length;i++) 
        	if(arr[i]%divisor==0)
        		list.add(arr[i]);
        
        /* 
         * 리스트가 비어있다는 것은 divisor로 
         * 나눠 떨어지는 배열의 값이 하나도 없다는 의미이기 때문에 
         * 리스트에 -1저장
         */
        if(list.isEmpty())
        	list.add(-1);
        
        answer=new int[list.size()];
        
        // 리스트의 값을 answer 배열에 저장
        for(int i=0;i<list.size();i++)
        	answer[i]=list.get(i);
        
        // answer 배열 정렬
        Arrays.sort(answer);
        
        return answer;
    }
}
