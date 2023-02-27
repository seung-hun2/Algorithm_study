package programmers;

import java.util.Stack;

public class rightBracket {
    boolean Solution(String s){
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') stack.push('(');
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else answer = false;
            }

            if(!answer) break;

        }
        if(!stack.isEmpty()) answer = false;


        return answer;
    }
}
