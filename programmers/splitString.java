package programmers;

public class splitString {
    public int solution(String s) {
        int answer = 0;
        int cnt = 0;
        char c = ' ';

        for(int i=0;i<s.length();i++){
            if(cnt == 0 ) {                 //  남은 카운트가 없으면 들어 오는 알파벳 저장 후 정답 수 추가
                c = s.charAt(i);
                answer++;
            }
            if(c == s.charAt(i)) cnt++;     // 들어오는 숫자가 저장된 알파벳과 같으면 카운트 추가
            else cnt--;                     // 다르면 카운트 감소

        }


        return answer;
    }
}
