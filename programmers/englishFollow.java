package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class englishFollow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(),"[\",] ");
        int turn=0;

        ArrayList<String> al = new ArrayList<>();
        char last = 0;
        int token=0;
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            turn++;
            token++;
            if(!al.contains(str) || last != str.charAt(0)){
                al.add(str);
            }else{
                break;
            }
            last = str.charAt(str.length()-1);
        }
        int[] answer = {0,0};
        if(turn !=0) {
            answer[1] = turn / n ;
            answer[0] = turn % n ;
        }
        if(turn%n==0){
            answer[1] = turn / n;
            answer[0] = n;
            if(turn==token){
                answer[1]=0;
                answer[0]=0;
            }
        }
//        System.out.println("["+answer[0]+","+answer[1]+"]");

    }
}
