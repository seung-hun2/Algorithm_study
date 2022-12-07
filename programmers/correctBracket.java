package programmers;

public class correctBracket {
    boolean solution(String s) {
        boolean answer = true;

        int bracket=0;
        boolean check = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                bracket++;
            }else{
                bracket--;
            }
            if(bracket<0){
                check = true;
            }
        }
        if(bracket==0){
            answer = true;
        }else{
            answer = false;
        }

        if(check == true){
            answer = false;
        }

        return answer;
    }
}
