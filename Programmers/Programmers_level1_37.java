import java.util.*;

public class level1_37 {
	public int[] solution(int[] answers) {
        int[] answer = {};
        
        // 각 수포자마다 찍는 패턴을 배열에 저장
        int[] person1={1,2,3,4,5}; 
        int[] person2={2,1,2,3,2,4,2,5};
        int[] person3={3,3,1,1,2,2,4,4,5,5};
        int result1=0, result2=0, result3=0;
        
        // 정답 개수 count
        for(int i=0;i<answers.length;i++) {
        	if(person1[i%person1.length]==answers[i]) result1++;
        	if(person2[i%person2.length]==answers[i]) result2++;
        	if(person3[i%person3.length]==answers[i]) result3++;
        }
        
        // 가장 많이 맞춘 개수 max에 저장
        int max=Math.max(result1,Math.max(result2, result3));
        
        // max와 정답 개수가 같은 사람 리스트에 저장, 자동으로 오름차순
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(max==result1) list.add(1);
        if(max==result2) list.add(2);
        if(max==result3) list.add(3);
        
        // 리스트에 저장된 값들 answer 배열에 복사
        answer=new int[list.size()];
        for(int i=0;i<answer.length;i++)
        	answer[i]=list.get(i);
        
        return answer;
    }
}
