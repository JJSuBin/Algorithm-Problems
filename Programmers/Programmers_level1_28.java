import java.util.*;
public class level1_28 {
	public int[] solution(int []arr) {
        int[] answer;
        ArrayList<Integer> list=new ArrayList<Integer>();
        
        int prev=-1; // 나올 수 없는 값으로 초기화
        for(int i=0;i<arr.length;i++) {
        	// 연속하는 같은 숫자가 아니라면 리스트에 저장
        	if(arr[i]!=prev)
        		list.add(arr[i]);
        	prev=arr[i]; // 이전 값 갱신
        }
        
        // list에 저장된 값 answer 배열에 저장
        answer=new int[list.size()];
        for(int i=0;i<list.size();i++)
        	answer[i]=list.get(i);
        
        return answer;
    }
}
