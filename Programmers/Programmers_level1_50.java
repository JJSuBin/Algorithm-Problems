import java.util.*;

public class level1_50 {
	public int solution(int[][] board, int[] moves) {
        int answer=0;
        Stack<Integer> result=new Stack<Integer>(); // 
    
        for(int i=0;i<moves.length;i++) {
        	/*
        	 * 삭제하고자 하는 아이템이 있는 열
        	 * moves는 배열의 인덱스를 1부터 세기 때문에 -1을 해줘야 한다. 
        	 */
        	int col=moves[i]-1; 
        	
        	// 보드의 해당 열에 아이템을 있을 떄 까지 탐색
        	for(int j=0;j<board.length;j++) {
        		if(board[j][col]>0) { // 보드에 아이템이 있을 경우
        			// 스택에 저장된 아이템이 있을 경우
        			if(!result.isEmpty()) { 
        				// 제일 최근에 삽입된 아이템과 이번에 삽입될 아이템이 같은 경우
        				if(result.peek()==board[j][col]) {
        					result.pop(); // 스택에 있던 아이템 제거
        					answer+=2; // 2개의 아이템 count
        				}
        				/* 
        				 * 제일 최근에 삽입된 아이템과 이번에 
        				 * 삽입될 아이템이 같지 않다면 스택에 아이템 삽입
        				 */
        				else
        					result.push(board[j][col]);
        			}
        			// 아이템을 꺼내서 비교해볼 수 없을 경우 해당 아이템 스택에 삽입
        			else
        				result.push(board[j][col]);
        			
        			board[j][col]=0; // 해당 보드의 아이템을 삭제해준다.
        			break;
        		}
        		
        	}
        }
		return answer;
	}
