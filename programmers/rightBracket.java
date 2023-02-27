package programmers;

import java.util.Stack;

public class rightBracket {
    boolean Solution(String s){
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') stack.push('(');     // '(' 이 들어오면 push
            else{
                if(!stack.isEmpty()){
                    stack.pop();                             // ')' 이 들어오면 pop
                }
                else answer = false;
            }

            if(!answer) break;                               // false 가 될 시 break

        }
        if(!stack.isEmpty()) answer = false;                // stack 이 비어있지 않으면 쌍이 맞지 않다.


        return answer;
    }
}
