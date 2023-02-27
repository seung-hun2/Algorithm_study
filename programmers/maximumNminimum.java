package programmers;

import java.util.StringTokenizer;

public class maximumNminimum {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s," ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int cnt = st.countTokens();

        for(int i=0;i<cnt;i++){
            int num = Integer.parseInt(st.nextToken());

            if(num > max) max = num;
            if(num < min) min = num;
        }
        answer += (min+" "+max);

        return answer;
    }
}
