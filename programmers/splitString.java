package programmers;

public class splitString {
    public int solution(String s) {
        int answer = 0;
        int cnt = 0;
        char c = ' ';

        for(int i=0;i<s.length();i++){
            if(cnt == 0 ) {
                c = s.charAt(i);
                answer++;
            }
            if(c == s.charAt(i)) cnt++;
            else cnt--;

        }


        return answer;
    }
}
